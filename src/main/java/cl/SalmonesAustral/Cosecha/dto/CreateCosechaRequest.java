package cl.SalmonesAustral.Cosecha.dto;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * DTO para crear una nueva cosecha (POST)
 * No incluye ID porque se genera automáticamente
 */
public record CreateCosechaRequest(

        @NotNull(message = "El jaulaId es obligatorio")
        @Positive(message = "El jaulaId debe ser mayor que 0")
        Integer jaulaId,

        @PositiveOrZero(message = "La cantidad no puede ser negativa")
        int cantidad,

        @PositiveOrZero(message = "El peso total no puede ser negativo")
        double pesoTotal

) {
}

