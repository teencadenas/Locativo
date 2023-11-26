/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author teenc
 */
@Entity
public class ServiciosRealizados implements Serializable{
   
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private String idServicioRealizado;
    @OneToOne
    private Empleado empleado;
    @OneToOne
    private OrdenTrabajo ordenTrabajo;
    @OneToMany (mappedBy = "ServiciosRealizados")
    private ArrayList<Servicio> servicioRealizados;

    public ServiciosRealizados(String idServicioRealizado, Empleado empleado, OrdenTrabajo ordenTrabajo, ArrayList<Servicio> servicioRealizados) {
        this.idServicioRealizado = idServicioRealizado;
        this.empleado = empleado;
        this.ordenTrabajo = ordenTrabajo;
        this.servicioRealizados = servicioRealizados;
    }

    public ServiciosRealizados() {
    }

    public ArrayList<Servicio> getServicioRealizados() {
        return servicioRealizados;
    }

    public void setServicioRealizados(ArrayList<Servicio> servicioRealizados) {
        this.servicioRealizados = servicioRealizados;
    }

    public String getIdServicioRealizado() {
        return idServicioRealizado;
    }

    public void setIdServicioRealizado(String idServicioRealizado) {
        this.idServicioRealizado = idServicioRealizado;
    }

    public Empleado getIempleado() {
        return empleado;
    }

    public void setempleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public OrdenTrabajo getordenTrabajo() {
        return ordenTrabajo;
    }

    public void setordenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }
    

    
    
}
