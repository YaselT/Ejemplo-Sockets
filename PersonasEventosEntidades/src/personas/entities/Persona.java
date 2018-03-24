/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.entities;

import java.io.Serializable;

/**
 *
 * @author jsanchez
 */
public class Persona implements Serializable{
    private String id;
    private String nombre;
    private char sexo;
    private EstadoCivil estadoCivil;
    private boolean pasatiempoMusica;
    private boolean pasatiempoCine;
    private boolean pasatiempoDeporte;
    private boolean pasatiempoVideoJuegos;
    private boolean pasatiempoCocina;
    private boolean pasatiempoOtro;
    private String pasatiempoOtroTexto;    

    public Persona(String id, String nombre, char sexo, EstadoCivil estadoCivil, boolean pasatiempoMusica, boolean pasatiempoCine, boolean pasatiempoDeporte, boolean pasatiempoVideoJuegos, boolean pasatiempoCocina, boolean pasatiempoOtro, String pasatiempoOtroTexto) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.pasatiempoMusica = pasatiempoMusica;
        this.pasatiempoCine = pasatiempoCine;
        this.pasatiempoDeporte = pasatiempoDeporte;
        this.pasatiempoVideoJuegos = pasatiempoVideoJuegos;
        this.pasatiempoCocina = pasatiempoCocina;
        this.pasatiempoOtro = pasatiempoOtro;
        this.pasatiempoOtroTexto = pasatiempoOtroTexto;
    }
    public Persona() {
        this.id = "";
        this.nombre = "";
        this.sexo = ' ';
        this.estadoCivil = new EstadoCivil();
        this.pasatiempoMusica = false;
        this.pasatiempoCine = false;
        this.pasatiempoDeporte = false;
        this.pasatiempoVideoJuegos = false;
        this.pasatiempoCocina = false;
        this.pasatiempoOtro = false;
        this.pasatiempoOtroTexto = "";
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estadoCivil
     */
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the pasatiempoMusica
     */
    public boolean isPasatiempoMusica() {
        return pasatiempoMusica;
    }

    /**
     * @param pasatiempoMusica the pasatiempoMusica to set
     */
    public void setPasatiempoMusica(boolean pasatiempoMusica) {
        this.pasatiempoMusica = pasatiempoMusica;
    }

    /**
     * @return the pasatiempoCine
     */
    public boolean isPasatiempoCine() {
        return pasatiempoCine;
    }

    /**
     * @param pasatiempoCine the pasatiempoCine to set
     */
    public void setPasatiempoCine(boolean pasatiempoCine) {
        this.pasatiempoCine = pasatiempoCine;
    }

    /**
     * @return the pasatiempoDeporte
     */
    public boolean isPasatiempoDeporte() {
        return pasatiempoDeporte;
    }

    /**
     * @param pasatiempoDeporte the pasatiempoDeporte to set
     */
    public void setPasatiempoDeporte(boolean pasatiempoDeporte) {
        this.pasatiempoDeporte = pasatiempoDeporte;
    }

    /**
     * @return the pasatiempoVideoJuegos
     */
    public boolean isPasatiempoVideoJuegos() {
        return pasatiempoVideoJuegos;
    }

    /**
     * @param pasatiempoVideoJuegos the pasatiempoVideoJuegos to set
     */
    public void setPasatiempoVideoJuegos(boolean pasatiempoVideoJuegos) {
        this.pasatiempoVideoJuegos = pasatiempoVideoJuegos;
    }

    /**
     * @return the pasatiempoCocina
     */
    public boolean isPasatiempoCocina() {
        return pasatiempoCocina;
    }

    /**
     * @param pasatiempoCocina the pasatiempoCocina to set
     */
    public void setPasatiempoCocina(boolean pasatiempoCocina) {
        this.pasatiempoCocina = pasatiempoCocina;
    }

    /**
     * @return the pasatiempoOtro
     */
    public boolean isPasatiempoOtro() {
        return pasatiempoOtro;
    }

    /**
     * @param pasatiempoOtro the pasatiempoOtro to set
     */
    public void setPasatiempoOtro(boolean pasatiempoOtro) {
        this.pasatiempoOtro = pasatiempoOtro;
    }

    /**
     * @return the pasatiempoOtroTexto
     */
    public String getPasatiempoOtroTexto() {
        return pasatiempoOtroTexto;
    }

    /**
     * @param pasatiempoOtroTexto the pasatiempoOtroTexto to set
     */
    public void setPasatiempoOtroTexto(String pasatiempoOtroTexto) {
        this.pasatiempoOtroTexto = pasatiempoOtroTexto;
    }
}
