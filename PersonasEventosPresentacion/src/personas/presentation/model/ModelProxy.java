/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import personas.Protocol;
import personas.entities.EstadoCivil;
import personas.IModel;
import personas.entities.Persona;

/**
 *
 * @author jsanchez
 */
public class ModelProxy implements IModel{
    ObjectInputStream in;
    ObjectOutputStream out;

    public ModelProxy() {
        try{
            Socket skt = new Socket(Protocol.SERVER,Protocol.PORT);
            out = new ObjectOutputStream(skt.getOutputStream() );
            out.flush();
            in = new ObjectInputStream(skt.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
            System.exit(-1);
        }        
    }
    
    public Collection<EstadoCivil> getEstadosCiviles(){
        try {
            out.writeInt(Protocol.GET_ESTADOSCIVILES);
            out.flush();
            int error = in.readInt();
            return (Collection<EstadoCivil>) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error de comunicacion");
            return new Vector();
        }
    }
    
    public EstadoCivil getEstadoCivil(String codigo) throws Exception{
        EstadoCivil estdoCivil=null;
        try {
            out.writeInt(Protocol.GET_ESTADOCIVIL);
            out.writeObject(codigo);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
                estdoCivil = (EstadoCivil) in.readObject();
                return estdoCivil;
            }
            else{
                throw new Exception("Estado civil no existe");
            }
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Estado civil no existe");
        }
    }

    public Persona getPersona(String id) throws Exception{
        Persona persona=null;
        try {
            out.writeInt(Protocol.GET_PERSONA);
            out.writeObject(id);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
                persona = (Persona) in.readObject();
                return persona;
            }
            else{
                throw new Exception("Persona no existe");
            }
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Persona no existe");
        }
    }
    
    public void deletePersona(Persona p) throws Exception{
        try {
            out.writeInt(Protocol.DELETE_PERSONA);
            out.writeObject(p);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Persona no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Persona no existe");
        }
    }

    public void addPersona(Persona persona) throws Exception{
        try {
            out.writeInt(Protocol.ADD_PERSONA);
            out.writeObject(persona);
            out.flush();
            int error = in.readInt();
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Persona ya existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Persona ya existe");
        }
    }

    public void updatePersona(Persona persona) throws Exception{
        try {
            out.writeInt(Protocol.UPDATE_PERSONA);
            out.writeObject(persona);
            
            out.flush();
            int error = in.readInt();
            
            if (error == Protocol.ERROR_NO_ERROR){
            }
            else{
                throw new Exception("Persona no existe");
            }
            
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            throw new Exception("Persona no existe");
        }
    }
    
    public List<Persona> searchPersonas(Persona filtro){
        try {
            out.writeInt(Protocol.SEARCH_PERSONAS);
            out.writeObject(filtro);
            out.flush();
            int error = in.readInt();
            List<Persona> personas = (List<Persona>) in.readObject();
            return personas;
        } catch (Exception ex) {
            System.out.println("Error de comunicacion");
            return new ArrayList<Persona>();
        }
    }
    
    public void close(){
        try {
            out.writeInt(Protocol.CLOSE);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Error de comunicacion");
        }
    }
    
    public int estadistica(){
        try{
            out.writeInt(Protocol.ESTADISTICA);
            out.flush();
            
            
        }
        catch(IOException ex){
            System.out.println("Error de comunicacion");
        }
    }
   
}
