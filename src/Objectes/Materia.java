//CompareTo codi_materia
//Constructor, podem passar-hi un array, no?
//Falta: compareTo 

package Objectes;

public class Materia {
   String codimateria;
   Alumne[] alumne; //Array!!!!!!!

    public String getNom() {
        return codimateria;
    }

    public void setNom(String codimateria) {
        this.codimateria = codimateria;
    }

    public Alumne[] getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne[] alumne) {
        this.alumne = alumne;
    }

    @Override
    public String toString() {
        return "Materia{" + "codimateria=" + codimateria + ", alumne=" + alumne + '}';
    }
    public int compareTo(Materia m) {
        return m.getNom().compareTo(m.codimateria);
    }
   
}
