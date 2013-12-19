//CompareTo codi_materia
//Constructor, podem passar-hi un array, no?
//Falta: compareTo 

package Objectes;

public class Materia implements Comparable<Materia>{
   private String codimateria;
   private Alumne[] alumne; //Array!!!!!!!

   
    Materia(String codim, Alumne[] alumnes){
    	codimateria = codim;
    	alumne = alumnes;
    }
    public String getCodi() {
        return codimateria;
    }

    public Alumne[] getAlumne() {
        return alumne;
    }

    @Override
    public String toString() {
        return "Materia{" + "codimateria=" + codimateria + ", alumne=" + alumne + '}';
    }
    public int compareTo(Materia m) {
        return codimateria.compareTo(m.getCodi());
    }
   
}
