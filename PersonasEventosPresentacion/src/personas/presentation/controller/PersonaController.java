/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.controller;

import java.util.List;
import personas.Application;
import personas.entities.EstadoCivil;
import personas.entities.Persona;
import personas.presentation.model.ModelProxy;
import personas.presentation.model.PersonaModel;
import personas.presentation.view.PersonaView;

/**
 *
 * @author jsanchez
 */
public class PersonaController {
    PersonaView view;
    PersonaModel model;
    
    public PersonaController(PersonaView view, PersonaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void guardar(){
        Persona nueva = new Persona();
        model.clearErrors();
        
        nueva.setId(view.idFld.getText());
        if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        
        nueva.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        
        if (view.sexoFldFem.isSelected()) nueva.setSexo('F');
        else if (view.sexoFldMasc.isSelected()) nueva.setSexo('M');
        else nueva.setSexo(' ');
        if (!view.sexoFldFem.isSelected() && !view.sexoFldMasc.isSelected()){
            model.getErrores().put("sexo", "Sexo requerido");
        }
        
        nueva.setEstadoCivil((EstadoCivil) view.estadoFld.getSelectedItem());
        
        nueva.setPasatiempoMusica(view.pasatiempoFldMusica.isSelected());
        
        nueva.setPasatiempoCine(view.pasatiempoFldCine.isSelected());
        
        nueva.setPasatiempoDeporte(view.pasatiempoFldDeporte.isSelected());
        
        nueva.setPasatiempoVideoJuegos(view.pasatiempoFldVideoJuegos.isSelected());
        
        nueva.setPasatiempoCocina(view.pasatiempoFldCocina.isSelected());
        
        nueva.setPasatiempoOtro(view.pasatiempoFldOtro.isSelected());
        
        nueva.setPasatiempoOtroTexto(view.pasatiempoFldOtroDescripcion.getText());
        if (view.pasatiempoFldOtro.isSelected() && view.pasatiempoFldOtroDescripcion.getText().length()==0){
            model.getErrores().put("pasatiempoOtroDescripcion", "Pasatiempo requerido");
        }
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        Application.Model.addPersona(nueva);
                        model.setMensaje("PERSONA AGREGADA");
                        model.setPersonaCurrent(new Persona());
                        
                        List<Persona> rowsAgr = Application.Model.searchPersonas(model.getFiltro());
                        model.setPersonas(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        Application.Model.updatePersona(nueva);
                        model.setMensaje("PERSONA MODIFICADADA");
                        model.setPersonaCurrent(nueva);
                        
                        List<Persona> rowsMod = Application.Model.searchPersonas(model.getFiltro());
                        model.setPersonas(rowsMod);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Persona ya existe");
                model.setMensaje("PERSONA YA EXISTE");
                model.setPersonaCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setPersonaCurrent(nueva);
        }
    }   
}
