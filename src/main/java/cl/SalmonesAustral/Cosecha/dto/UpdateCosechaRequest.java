package cl.SalmonesAustral.Cosecha.dto;

import jakarta.validation.constraints.NotBlank;


/**
 * DTO para actualizar un libro existente (PUT) No incluye ID porque se obtiene del path parameter
 */
public record UpdateCosechaRequest(
    @NotBlank(message = "El estado es obligatorio")
    String estado,

    @NotBlank(message = "Las observaciones son obligatorias")
    String observaciones
) {
}
