/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.logic.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import personas.IModel;
import personas.entities.EstadoCivil;
import personas.entities.Persona;
import personas.entities.Estadistica;

/**
 *
 * @author jsanchez
 */
public class Model implements IModel {

    java.util.Hashtable<String, EstadoCivil> estadosCiviles;
    java.util.Hashtable<String, Persona> personas;
    Estadistica estadistica;

    public Hashtable<String, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Hashtable<String, Persona> personas) {
        this.personas = personas;
    }

    public Model() {
        initEstadosCiviles();
        initPersonas();
        estadistica = new Estadistica();
    }

    private void initPersonas() {
        Persona persona;
        personas = new java.util.Hashtable<String, Persona>();
        persona = new Persona("111", "Juan", 'M',
                estadosCiviles.get("001"), false, true, false, true, false, true, "Trompo");
        personas.put(persona.getId(), persona);
        persona = new Persona("222", "Maria", 'F',
                estadosCiviles.get("002"), true, false, true, false, false, false, "");
        personas.put(persona.getId(), persona);
    }

    private void initEstadosCiviles() {
        EstadoCivil estadoCivil;

        estadosCiviles = new java.util.Hashtable<String, EstadoCivil>();
        estadoCivil = new EstadoCivil("001", "Soltero");
        estadosCiviles.put(estadoCivil.getCodigo(), estadoCivil);
        estadoCivil = new EstadoCivil("002", "Casado");
        estadosCiviles.put(estadoCivil.getCodigo(), estadoCivil);
        estadoCivil = new EstadoCivil("003", "Viudo");
        estadosCiviles.put(estadoCivil.getCodigo(), estadoCivil);
        estadoCivil = new EstadoCivil("004", "Divorciado");
        estadosCiviles.put(estadoCivil.getCodigo(), estadoCivil);
        estadoCivil = new EstadoCivil("005", "Union Libre");
        estadosCiviles.put(estadoCivil.getCodigo(), estadoCivil);
    }

    public Collection<EstadoCivil> getEstadosCiviles() {
        return new Vector(estadosCiviles.values());
    }

    public EstadoCivil getEstadoCivil(String codigo) throws Exception {
        EstadoCivil estdoCivil = estadosCiviles.get(codigo);
        if (estdoCivil == null) {
            throw new Exception("Estado civil no existe");
        } else {
            return estdoCivil;
        }
    }

    public Persona getPersona(String id) throws Exception {
        Persona persona = personas.get(id);
        if (persona == null) {
            throw new Exception("Persona no existe");
        } else {
            return persona;
        }
    }

    public void deletePersona(Persona p) throws Exception {
        if (personas.get(p.getId()) == null) {
            throw new Exception("Persona no existe");
        } else {
            personas.remove(p.getId());
        }
    }

    public void addPersona(Persona persona) throws Exception {
        if (personas.get(persona.getId()) != null) {
            throw new Exception("Persona ya existe");
        } else {
            personas.put(persona.getId(), persona);
        }
    }

    public void updatePersona(Persona persona) throws Exception {
        if (personas.get(persona.getId()) == null) {
            throw new Exception("Persona no existe");
        } else {
            personas.put(persona.getId(), persona);
        }
    }

    public List<Persona> searchPersonas(Persona filtro) {
        List<Persona> resultado;
        resultado = new ArrayList<Persona>();
        for (Persona p : personas.values()) {
            if (p.getNombre().contains(filtro.getNombre())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public void close() {
    }

    public int estadistica() throws Exception {
        int M, F;
        int est;
        M = F = 0;
        List<Persona> resultado;
        resultado = new ArrayList<Persona>();
        for (Persona p : personas.values()) {
            if (p.getSexo() == 'M') {
                M = M + 1;
                estadistica.setHombres(M);
            } else {
                F = F + 1;
                estadistica.setMujeres(F);
            }
        }
        if (M == 0 && F == 0) {
            est = 0;
        } else {
            est = ((estadistica.getMujeres() * 100) / (estadistica.getHombres() + estadistica.getMujeres()));
        }

        return est;
    }

}
