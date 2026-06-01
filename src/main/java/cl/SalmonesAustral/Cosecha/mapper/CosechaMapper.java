package cl.SalmonesAustral.Cosecha.mapper;


import cl.SalmonesAustral.Cosecha.dto.CreateCosechaRequest;
import cl.SalmonesAustral.Cosecha.dto.CosechaResponse;
import cl.SalmonesAustral.Cosecha.modelo.Cosecha;

public class CosechaMapper {

    // DTO -> Entity
    public static Cosecha toEntity(CreateCosechaRequest request) {
        Cosecha cosecha = new Cosecha();
        cosecha.setCantidad(request.cantidad());
        cosecha.setPesoTotal(request.pesoTotal());

        // ⚠ jaula se setea en el service (porque necesitas buscarla en BD)

        return cosecha;
    }

    public static CosechaResponse toResponse(Cosecha cosecha) {
    return new CosechaResponse(
            cosecha.getId(),
            (long) cosecha.getJaulaId(), //cast porque tienes int
            cosecha.getCantidad(),
            cosecha.getPesoTotal(),
            cosecha.getPesoPromedio(),
            cosecha.getEstado() // 
    );
}
}
