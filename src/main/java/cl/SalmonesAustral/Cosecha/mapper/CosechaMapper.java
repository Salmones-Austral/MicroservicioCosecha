package cl.SalmonesAustral.Cosecha.mapper;


import cl.SalmonesAustral.Cosecha.dto.CreateCosechaRequest;
import cl.SalmonesAustral.Cosecha.dto.UpdateCosechaRequest;
import cl.SalmonesAustral.Cosecha.modelo.Cosecha;

public class CosechaMapper {

    // DTO -> Entity
    public static Cosecha toEntity(CreateCosechaRequest request) {
        return new Cosecha(
            null,
            request.jaulaId(),
            request.fechaCosecha(),
            request.cantidad(),
            request.pesoTotal(),
            "PENDIENTE",
            "",
            null
        );
    }
    

    public static Cosecha toModel(int id, UpdateCosechaRequest request) {
        return new Cosecha(
            id,
            request.jaulaId(),
            request.fechaCosecha(),
            request.cantidad(),
            request.pesoTotal(),
            request.estado(),
            request.observaciones(),
            request.motivoBloqueo()
             
        );
    }
}

