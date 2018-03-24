
package personas.entities;

import java.io.Serializable;


public class Estadistica implements Serializable{
    public int hombres;
    public int mujeres;

    public Estadistica(int hombres, int mujeres) {
        this.hombres = hombres;
        this.mujeres = mujeres;
    }

    public Estadistica() {
        hombres = 0;
        mujeres = 0;
    }
    
    public int getHombres() {
        return hombres;
    }

    public void setHombres(int hombres) {
        this.hombres = hombres;
    }

    public void setMujeres(int mujeres) {
        this.mujeres = mujeres;
    }

    public int getMujeres() {
        return mujeres;
    }
    
    /*public double estadistica(){
        double estadistica;
        estadistica=((mujeres*100)/mujeres + hombres);
        return estadistica;
    }*/
    
}
