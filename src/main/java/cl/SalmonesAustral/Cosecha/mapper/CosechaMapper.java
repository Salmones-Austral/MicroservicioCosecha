package cl.SalmonesAustral.Cosecha.mapper;


import cl.SalmonesAustral.Cosecha.dto.CreateCosechaRequest;
import cl.SalmonesAustral.Cosecha.dto.UpdateCosechaRequest;
import cl.SalmonesAustral.Cosecha.modelo.Cosecha;

public class CosechaMapper {

    // DTO -> Entity
    public static Cosecha toEntity(CreateCosechaRequest request) {
        return new Cosecha(
            0,
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
            0, 
            null,
            0,
            0.0,
            request.estado(),
            request.observaciones(),
            null
             
        );
    }
}

