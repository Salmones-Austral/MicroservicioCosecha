package cl.SalmonesAustral.Cosecha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.SalmonesAustral.Cosecha.dto.CreateCosechaRequest;
import cl.SalmonesAustral.Cosecha.dto.UpdateCosechaRequest;
import cl.SalmonesAustral.Cosecha.mapper.CosechaMapper;
import cl.SalmonesAustral.Cosecha.modelo.Cosecha;
import cl.SalmonesAustral.Cosecha.service.CosechaService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cosecha")
public class CosechaController {

    private final CosechaService cosechaService;

    public CosechaController(CosechaService cosechaService) {
        this.cosechaService = cosechaService;
    }

    // Crear una nueva cosecha
    @PostMapping
    public ResponseEntity<Cosecha> crearCosecha(@Valid @RequestBody CreateCosechaRequest request) {
        Cosecha cosechaEntity=CosechaMapper.toEntity(request);

    //guardar
    Cosecha nueva=cosechaService.crearCosecha(cosechaEntity);
    return ResponseEntity.ok(nueva);
    }

    // Obtener todas las cosechas
    @GetMapping
    public ResponseEntity<List<Cosecha>> obtenerTodas() {
        return ResponseEntity.ok(cosechaService.obtenerTodas());
    }

    // Obtener cosecha por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cosecha> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(cosechaService.obtenerPorId(id));
    }
    @GetMapping("/rechazadas")
    public ResponseEntity<List<Cosecha>>obtenerRechazadas() {
        return ResponseEntity.ok(cosechaService.obtenerRechazadas());
    }
    //actualizar/bloquear cosecha (put)
    @PutMapping("/{id}")
    public ResponseEntity<Cosecha>actualizarCosecha(@PathVariable Integer id, @Valid @RequestBody UpdateCosechaRequest request) {
        Cosecha cosechaModificada=CosechaMapper.toModel(id, request);

        Cosecha actualizada=cosechaService.actualizarCosecha(id, cosechaModificada);
        return ResponseEntity.ok(actualizada);
    }

}