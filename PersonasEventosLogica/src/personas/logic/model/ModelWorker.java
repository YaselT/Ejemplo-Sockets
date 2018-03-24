/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.logic.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import personas.IModel;
import personas.Protocol;
import personas.entities.EstadoCivil;
import personas.entities.Persona;

/**
 *
 * @author jsanchez
 */
public class ModelWorker {
    Socket skt;
    ObjectInputStream in;
    ObjectOutputStream out;
    IModel Model;

    public ModelWorker(Socket skt, IModel Model) {
        this.skt = skt;
        this.Model=Model;
    }
    
    public void start(){
        try {
            out = new ObjectOutputStream(skt.getOutputStream() );
            out.flush();
            in = new ObjectInputStream(skt.getInputStream());
            System.out.println("Worker atendiendo peticiones...");
            Thread t = new Thread(new Runnable(){
                public void run(){
                    ModelWorker.this.run();
                }
            });
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(ModelWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run(){
        boolean continuar = true;
        int method;
        Persona p;
        EstadoCivil e;
        String id;
        while (continuar) {
            try {
                method = in.readInt();
                System.out.println("Operacion: "+method);
                switch(method){
                case Protocol.ADD_PERSONA:
                    p = (Persona)in.readObject();
                    try {
                        Model.addPersona(p);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception ex) {
                        out.writeInt(Protocol.ERROR_ADD_PERSONA);
                    }
                    break;
                case Protocol.DELETE_PERSONA:
                    p = (Persona)in.readObject();
                    try {
                        Model.deletePersona(p);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception ex) {
                        out.writeInt(Protocol.ERROR_DELETE_PERSONA);
                    }
                    break;
                case Protocol.GET_ESTADOCIVIL:
                    id = (String)in.readObject();
                    try {
                        e=Model.getEstadoCivil(id);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                        out.writeObject(e);
                    } catch (Exception ex) {
                        out.writeInt(Protocol.ERROR_GET_ESTADOCIVIL);
                    }
                    break;
                case Protocol.GET_ESTADOSCIVILES:
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.getEstadosCiviles());
                    break;
                case Protocol.GET_PERSONA:
                    id = (String)in.readObject();
                    try {
                        p=Model.getPersona(id);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                        out.writeObject(p);
                    } catch (Exception ex) {
                        out.writeInt(Protocol.GET_PERSONA);
                    }
                    break;
                case Protocol.SEARCH_PERSONAS:
                    p = (Persona)in.readObject();
                    out.writeInt(Protocol.ERROR_NO_ERROR);
                    out.writeObject(Model.searchPersonas(p));
                    break;
                case Protocol.UPDATE_PERSONA:
                    p = (Persona)in.readObject();
                    try {
                        Model.updatePersona(p);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                    } catch (Exception ex) {
                        out.writeInt(Protocol.ERROR_UPDATE_PERSONA);
                    }
                    break;
                case Protocol.CLOSE:
                    skt.close();
                    continuar = false;
                    break;
                }
                out.flush();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex);
                continuar = false;
            }                        
        }
    }
}
