package cl.SalmonesAustral.Cosecha.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import cl.SalmonesAustral.Cosecha.modelo.Cosecha;
import cl.SalmonesAustral.Cosecha.repository.CosechaRepository;
import cl.SalmonesAustral.Cosecha.config.SanitarioClient;

@Service
public class CosechaService {

    private final CosechaRepository cosechaRepository;
    private final WebClient sanitarioWebClient;

    public CosechaService(CosechaRepository cosechaRepository, WebClient sanitarioWebClient) {
        this.cosechaRepository = cosechaRepository;
        this.sanitarioWebClient = sanitarioWebClient;
    }

    //CREAR COSECHA CON VALIDACIÓN SANITARIA
    public Cosecha crearCosecha(Cosecha cosecha) {

        //  VALIDACIÓN CONTRA MICROSERVICIO SANITARIO
        Boolean puede = sanitarioWebClient.get()
        .uri("/api/v1/sanitario/puede-cosechar/" + cosecha.getJaulaId())
        .retrieve()
        .bodyToMono(Boolean.class)
        .block();

        if (puede == null || !puede) {
            throw new RuntimeException("No se puede cosechar: La jaula tiene un tratamiento sanitario activo");
        }

        // Validaciones locales
        if (cosecha.getCantidad() < 0 || cosecha.getPesoTotal() < 0) {
            throw new IllegalArgumentException("Cantidad y peso total deben ser positivos");
        }
        cosecha.setId(null);
        return cosechaRepository.save(cosecha);
    }

    public List<Cosecha> obtenerTodas() {
        return cosechaRepository.findAll();
    }

    public Cosecha obtenerPorId(Integer id) {
        return cosechaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cosecha no encontrada"));
    }

    public List<Cosecha>obtenerRechazadas(){
        return cosechaRepository.findByEstado("RECHAZADA");
    }
        //actualizar cosecha (put)
        public Cosecha actualizarCosecha(Integer id, Cosecha cosechaModificada) {
            //rescata el registro original de la bd
            Cosecha cosechaExistente=obtenerPorId(id);
            cosechaModificada.setJaulaId(cosechaExistente.getJaulaId());
            cosechaModificada.setFechaCosecha(cosechaExistente.getFechaCosecha());
            cosechaModificada.setCantidad(cosechaExistente.getCantidad());
            cosechaModificada.setPesoTotal(cosechaExistente.getPesoTotal());

            if("BLOQUEADA".equalsIgnoreCase(cosechaModificada.getEstado())) {
                if(cosechaModificada.getMotivoBloqueo()==null) {
                    cosechaModificada.setMotivoBloqueo("Bloqueo automatico preventivo por Tratamiento ");
                }
            }
            return cosechaRepository.save(cosechaModificada);
        }
    }
