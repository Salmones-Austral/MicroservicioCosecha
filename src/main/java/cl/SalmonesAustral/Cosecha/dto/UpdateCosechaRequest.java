package cl.SalmonesAustral.Cosecha.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;



/**
 * DTO para actualizar un libro existente (PUT) No incluye ID porque se obtiene del path parameter
 */
public record UpdateCosechaRequest(
    @NotNull(message = "El ID de la jaula es obligatorio")
    Integer jaulaId,
    
    LocalDateTime fechaCosecha,

    @PositiveOrZero(message = "La cantidad no puede ser negativa")
    int cantidad,

    @PositiveOrZero(message = "El peso total no puede ser negativo")
    double pesoTotal,

    @NotBlank(message = "El estado es obligatorio")
    String estado,

    String observaciones,

    String motivoBloqueo
) {
}
