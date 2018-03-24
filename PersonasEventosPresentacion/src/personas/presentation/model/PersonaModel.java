/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import personas.Application;
import personas.entities.EstadoCivil;
import personas.entities.Persona;

/**
 *
 * @author jsanchez
 */
public class PersonaModel extends java.util.Observable {

    public PersonaModel() {
        initPersona();
        initPersonas();
    }

//======= PERSONA ============    
    Persona personaCurrent;
    ComboBoxModel<EstadoCivil> estadosCiviles;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initPersona(){
        setEstadosCiviles(new DefaultComboBoxModel(Application.Model.getEstadosCiviles().toArray(new EstadoCivil[0])));
        setPersonaCurrent(new Persona());
        clearErrors();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Hashtable<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Hashtable<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new Hashtable<String,String>());
        setMensaje("");
        
    }
    public Persona getPersonaCurrent() {
        return personaCurrent;
    }

    public void setPersonaCurrent(Persona personaCurrent) {
        this.personaCurrent = personaCurrent;
        setChanged();
        notifyObservers(PERSONA_CURRENT);        
    }

    public ComboBoxModel<EstadoCivil> getEstadosCiviles() {
        return estadosCiviles;
    }

    public void setEstadosCiviles(ComboBoxModel<EstadoCivil> estadosCiviles) {
        this.estadosCiviles = estadosCiviles;
        setChanged();
        notifyObservers();        
    }

//======== PERSONAS ===========
    Persona filtro;
    PersonaTableModel personasModel;
    
    private void initPersonas(){
        filtro = new Persona();
        List<Persona> rows = new ArrayList<Persona>();
        setPersonas(rows);
    }
    
    public void setPersonas(List<Persona> rows){
        int[] cols={PersonaTableModel.ID,PersonaTableModel.NOMBRE,PersonaTableModel.SEXO,PersonaTableModel.PASATIEMPO_CINE,PersonaTableModel.ESTADO_CIVIL};
        setPersonasModel(new PersonaTableModel(cols,rows));        
    }
    
    public Persona getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Persona filtro) {
        this.filtro = filtro;
    }
    
     public PersonaTableModel getPersonasModel() {
        return personasModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(PERSONA_CURRENT);
        setChanged();        
        notifyObservers(PERSONAS_MODEL);
    }
    
    public void setPersonasModel(PersonaTableModel personasModel) {
        this.personasModel = personasModel;
        setChanged();
        notifyObservers(PERSONAS_MODEL);
    }
    
    public static Integer PERSONA_CURRENT=1;
    public static Integer PERSONAS_MODEL=2;
}
