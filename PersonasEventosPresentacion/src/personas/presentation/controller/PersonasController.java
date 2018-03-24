/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import personas.Application;
import personas.entities.Persona;
import personas.presentation.model.ModelProxy;
import personas.presentation.model.PersonaModel;
import personas.presentation.view.PersonasView;

/**
 *
 * @author jsanchez
 */
public class PersonasController {
    PersonasView view;
    PersonaModel model;
    
    public PersonasController(PersonasView view, PersonaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
        model.getFiltro().setNombre(view.nombreFld.getText());
Persona filtro= new Persona();
filtro.setNombre(model.getFiltro().getNombre());
List<Persona> rows = Application.Model.searchPersonas(filtro);
        //List<Persona> rows = Model.searchPersonas(model.getFiltro());
        model.setPersonas(rows);
    }

    public void preAgregar(){
        model.clearErrors();
        model.setModo(Application.MODO_AGREGAR);
        model.setPersonaCurrent(new Persona());
        Application.PERSONA_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        Persona seleccionada = model.getPersonasModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setPersonaCurrent(seleccionada);
        Application.PERSONA_VIEW.setVisible(true);
    }

    public void borrar(int row){
        Persona seleccionada = model.getPersonasModel().getRowAt(row); 
        try {
            Application.Model.deletePersona(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Persona> rowsMod = Application.Model.searchPersonas(model.getFiltro());
        model.setPersonas(rowsMod);
    }
    
    public void close(){
        Application.Model.close();
    }
    
}
