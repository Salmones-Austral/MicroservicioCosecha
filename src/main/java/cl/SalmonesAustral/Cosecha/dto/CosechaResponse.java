package cl.SalmonesAustral.Cosecha.dto;

public record CosechaResponse(
    Long id,
    Long jaulaId,
    int cantidad,
    double pesoTotal,
    double pesoPromedio,
    String estado
) {}
