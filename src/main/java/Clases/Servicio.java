package Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Servicio implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private String idServicio ;
    private String nombreServicio ;
    private String descripcion;
    @ManyToOne
    private OrdenTrabajo ordenTrabajo;
    @ManyToOne
    private ServiciosRealizados serviciosRealizados;

    public Servicio(String idServicio, String nombreServicio, String descripcion) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
    }

    public Servicio() {
    }
    
    public String getIdServicio() {
        return this.idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return this.nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
