/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import personas.presentation.model.ModelProxy;
import personas.presentation.controller.PersonaController;
import personas.presentation.controller.PersonasController;
import personas.presentation.model.PersonaModel;
import personas.presentation.view.PersonaView;
import personas.presentation.view.PersonasView;

/**
 *
 * @author jsanchez
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Model=new ModelProxy();
        //Model=new Model();
        PersonaModel personaModel = new PersonaModel();
        
        PersonasView personasView= new PersonasView();
        PERSONAS_VIEW=personasView;
        PersonasController personascontroller = new PersonasController(personasView,personaModel);
        personasView.setVisible(true);

        PersonaView personaView = new PersonaView(personasView,true);
        PERSONA_VIEW=personaView;
        PersonaController personacontroller = new PersonaController(personaView,personaModel);
     }
    
    public static PersonaView PERSONA_VIEW;
    public static PersonasView PERSONAS_VIEW;    
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    public static IModel Model;
}
