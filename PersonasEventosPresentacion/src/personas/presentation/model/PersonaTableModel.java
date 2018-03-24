/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.model;

import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;
import personas.entities.Persona;

/**
 *
 * @author jsanchez
 */
public class PersonaTableModel extends AbstractTableModel{
    List<Persona> rows;
    int[] cols;

    public  PersonaTableModel(int[] cols, List<Persona> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case SEXO: return Icon.class;
            case PASATIEMPO_CINE: return Boolean.class;
            case ESTADO_CIVIL: return Icon.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Persona persona = rows.get(row);
        switch (cols[col]){
            case ID: return persona.getId();
            case NOMBRE: return persona.getNombre();
            //case SEXO: return persona.getSexo();
            case SEXO: 
                if (persona.getSexo()=='M') return new ImageIcon( getClass().getResource( "male.png" ) ); 
                else  return new ImageIcon( getClass().getResource( "female.png" ) );  
            case ESTADO_CIVIL: return estadoCivil(persona);
            //case ESTADO_CIVIL: return persona.getEstadoCivil().getDescripcion();
            case PASATIEMPO_MUSICA: return persona.isPasatiempoMusica();
            case PASATIEMPO_CINE: return persona.isPasatiempoCine();
            case PASATIEMPO_DEPORTE: return persona.isPasatiempoDeporte();
            case PASATIEMPO_VIDEOJUEGOS: return persona.isPasatiempoVideoJuegos();
            case PASATIEMPO_COCINA: return persona.isPasatiempoCocina();
            case PASATIEMPO_OTRO: return persona.isPasatiempoOtro();
            case PASATIEMPO_OTROTEXTO: return persona.getPasatiempoOtroTexto();
            default: return "";
        }
    }    
    
    private Icon estadoCivil(Persona p){
        String file="Soltero";
        if (p.getEstadoCivil().getDescripcion().equals("Soltero")) file="single.png" ;
        if (p.getEstadoCivil().getDescripcion().equals("Casado")) file="married.png" ;
        if (p.getEstadoCivil().getDescripcion().equals("Viudo")) file="widower.png" ;
        if (p.getEstadoCivil().getDescripcion().equals("Divorciado")) file="divorced.png" ;
        if (p.getEstadoCivil().getDescripcion().equals("Union Libre")) file="concubinage.png" ;
        return new ImageIcon( getClass().getResource( file ) ); 
    }
    public static final int ID=0;
    public static final int NOMBRE=1;
    public static final int SEXO=2;
    public static final int ESTADO_CIVIL=3;
    public static final int PASATIEMPO_MUSICA=4;
    public static final int PASATIEMPO_CINE=5;
    public static final int PASATIEMPO_DEPORTE=6;
    public static final int PASATIEMPO_VIDEOJUEGOS=7;
    public static final int PASATIEMPO_COCINA=8;
    public static final int PASATIEMPO_OTRO=9;
    public static final int PASATIEMPO_OTROTEXTO=10;  
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[NOMBRE]= "Nombre";
        colNames[SEXO]= "Sexo";
        colNames[ESTADO_CIVIL]= "Estado";
        colNames[PASATIEMPO_MUSICA]= "Musica";
        colNames[PASATIEMPO_CINE]= "Cine";
        colNames[PASATIEMPO_DEPORTE]= "Deporte";
        colNames[PASATIEMPO_VIDEOJUEGOS]= "Juegos";
        colNames[PASATIEMPO_COCINA]= "Cocina";
        colNames[PASATIEMPO_OTRO]= "Otro";
        colNames[PASATIEMPO_OTROTEXTO]= "Otro Descrip.";
    }
    
    public Persona getRowAt(int row) {
        return rows.get(row);
    }
        
}
