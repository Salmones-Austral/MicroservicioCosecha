package cl.SalmonesAustral.Cosecha.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Tabla_cosecha"
)
public class Cosecha {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "jaula_id", nullable = false)
    private Integer jaulaId;

    @Column(name = "fecha_cosecha", nullable = false)
    private LocalDateTime fechaCosecha;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "peso_total", nullable = false)
    private double pesoTotal;
   
    // PENDIENTE - REALIZADA - RECHAZADA - BLOQUEADA
    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @Column(name = "motivo_bloqueo", length = 500)
    private String motivoBloqueo;

    public Cosecha() {}

    public Cosecha(Integer id, Integer jaulaId, LocalDateTime fechaCosecha, int cantidad, double pesoTotal, String estado,
        String observaciones, String motivoBloqueo) {
            this.id=id;
            this.jaulaId=jaulaId;
            this.fechaCosecha=fechaCosecha;
            this.cantidad=cantidad;
            this.pesoTotal=pesoTotal;
            this.estado=estado;
            this.observaciones=observaciones;
            this.motivoBloqueo=motivoBloqueo;

        }

    // GETTERS Y SETTERS

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id=id;
    }

    public Integer getJaulaId() {
        return jaulaId;
    }

    public void setJaulaId(Integer jaulaId) {
        this.jaulaId = jaulaId;
    }

    public LocalDateTime getFechaCosecha() {
        return fechaCosecha;
    }

    public void setFechaCosecha(LocalDateTime fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
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
    public String getMotivoBloqueo() {
        return motivoBloqueo;
    }
    public void setMotivoBloqueo(String motivoBloqueo) {
        this.motivoBloqueo=motivoBloqueo;
    }
}
