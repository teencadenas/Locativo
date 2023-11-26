/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.persistence.Basic;
import javax.persistence.Entity;



/**
 *
 * @author teenc
 */

@Entity
public class Empleado extends Persona{
   
    
    @Basic
    private String cargo ;
    private String mailEmpresa ;
    private String estado;

  

    public Empleado(String nombre, String apellido, String telefono, String mailPersona, String identificacion,
            String cargo, String mailEmpresa, String estado) {
        super(nombre, apellido, telefono, mailPersona, identificacion);
        this.cargo = cargo;
        this.mailEmpresa = mailEmpresa;
        this.estado = estado;
    }

    public Empleado() {
    }
   
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the mailEmpresa
     */
    public String getMailEmpresa() {
        return mailEmpresa;
    }

    /**
     * @param mailEmpresa the mailEmpresa to set
     */
    public void setMailEmpresa(String mailEmpresa) {
        this.mailEmpresa = mailEmpresa;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
