package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class OrdenTrabajo implements Serializable {
    @Id
    private String idOrdenTrabajo;
    @Basic
    private String estado;
    @OneToOne
    private UnidadComercial unidadCo;
    @Basic
    private String fechaSolicitud;
    private String fechaCierre;
    @OneToMany(mappedBy = "OrdenTrabajo")
    private ArrayList<Servicio> serviciosSolicitados;

    public OrdenTrabajo(String idOrdenTrabajo, String estado, UnidadComercial unidadCo, String fechaSolicitud, String fechaCierre, ArrayList serviciosSolicitados) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.estado = estado;
        this.unidadCo = unidadCo;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaCierre = fechaCierre;
        this.serviciosSolicitados = serviciosSolicitados;
    }

    public OrdenTrabajo() {
    }
    
    

    public String getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(String idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UnidadComercial getUnidadCo() {
        return unidadCo;
    }

    public void setUnidadCo(UnidadComercial unidadCo) {
        this.unidadCo = unidadCo;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public ArrayList getidServiciosSolicitados() {
        return serviciosSolicitados;
    }

    public void setIdServiciosSolicitados(ArrayList serviciosSolicitados) {
        this.serviciosSolicitados = serviciosSolicitados;
    }

    
}    