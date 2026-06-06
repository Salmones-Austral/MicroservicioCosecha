package cl.SalmonesAustral.Cosecha.dto;

import jakarta.validation.constraints.PositiveOrZero;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * DTO para crear una nueva cosecha (POST)
 * No incluye ID porque se genera automáticamente
 */
public record CreateCosechaRequest(

        @NotNull(message = "El ID de jaula es obligatorio")
        @Positive(message = "El ID debe ser mayor que 0")
        Integer jaulaId,

        @NotNull(message = "La fecha es obligatoria")
        LocalDateTime fechaCosecha,

        @PositiveOrZero(message = "La cantidad no puede ser negativa")
        int cantidad,

        @PositiveOrZero(message = "El peso total no puede ser negativo")
        double pesoTotal

) {
}

