/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.util.Collection;
import java.util.List;
import personas.entities.EstadoCivil;
import personas.entities.Persona;

/**
 *
 * @author jsanchez
 */
public interface IModel {
    public  Collection<EstadoCivil> getEstadosCiviles();
    public  EstadoCivil getEstadoCivil(String codigo) throws Exception;
    public  Persona getPersona(String id) throws Exception;
    public  void deletePersona(Persona p) throws Exception;
    public  void addPersona(Persona persona) throws Exception;
    public  void updatePersona(Persona persona) throws Exception;
    public  List<Persona> searchPersonas(Persona filtro);
    public  void close();
    public int estadistica()throws Exception;
}
