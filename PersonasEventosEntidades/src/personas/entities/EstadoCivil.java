/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.entities;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author jsanchez
 */
public class EstadoCivil implements Serializable{
    String codigo;
    String descripcion;

    public EstadoCivil() {
       codigo = "";
        descripcion = "";        
    }
    public EstadoCivil(String codigo, 
                    String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String toString() {
        return descripcion;
    }
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstadoCivil other = (EstadoCivil) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
 }
