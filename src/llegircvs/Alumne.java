package llegircvs;

//S'ha de fer el compareTo per a ordenar-los:

//Falta: compareTo i to String


public class Alumne implements Comparable<Alumne> {
    private String nom;
    private String cognom;
    private String grup;
    //Al fer XML hem d'ajuntar Congom, Nom
    
    //Constructor principal
    Alumne(String nom, String cognom, String grup){
        this.nom = nom;
        this.cognom = cognom;
        this.grup = grup;
    }
    Alumne(String nom, String cognom){
        
        this.nom = nom;
        this.cognom = cognom;
    }
    
    public String getNom() {
        
        return nom;
    }

    public String getCognom() {
        
        return cognom;
    }

    public String getGrup() {
        return grup;
    }

    //Retoquem per fer més maco?
    //Hem de pensar com sortirà per a passar-lo pel GUI
    @Override
    public String toString() {
        return "Alumne{" + "nom=" + nom + ", cognom=" + cognom + ", grup=" + grup + '}';
    }

    
    @Override
    public int compareTo(Alumne t){
        //Primer per cognom i despés per nom
        if (cognom.compareTo(t.getCognom()) == 0) {
                if(nom.compareTo(t.getNom()) == 0){
                    return 0;
                }else return nom.compareTo(t.getNom());
        }else return cognom.compareTo(t.getCognom());
    }
    
    
    /*public int comparAlumnesumne (Alumne t) {
        //Primer per cognom i despés per nom
        if (cognom.compareTo(t.getCognom()) == 0) {
                if(nom.compareTo(t.getNom()) == 0){
                    return 0;
                }else return nom.compareTo(t.getNom());
        }else return cognom.compareTo(t.getCognom());
    }*/
}


