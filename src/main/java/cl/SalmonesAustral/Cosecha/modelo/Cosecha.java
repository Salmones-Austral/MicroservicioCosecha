package cl.SalmonesAustral.Cosecha.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cosecha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación lógica con jaula
    private int jaulaId;

    // Fecha de cosecha
    private LocalDateTime fecha;

    // Cantidad de peces cosechados
    private int cantidad;

    // Peso total en kg
    private double pesoTotal;

    // Peso promedio (opcional pero útil)
    private double pesoPromedio;

    // Estado de la cosecha
    // PENDIENTE - REALIZADA - RECHAZADA
    private String estado;

    // Motivo en caso de rechazo
    private String observaciones;

    public Cosecha() {}

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public int getJaulaId() {
        return jaulaId;
    }

    public void setJaulaId(int jaulaId) {
        this.jaulaId = jaulaId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
