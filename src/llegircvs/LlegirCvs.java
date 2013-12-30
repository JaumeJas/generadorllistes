/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegircvs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LlegirCvs {

    private TreeMap<String, SortedSet> llistaMateriesAlumnes = new TreeMap<String, SortedSet>();
    private String csvFileToRead = "";
    public static void main(String[] args) {
        Intermediari in = new Intermediari();
        LlegirCvs l = new LlegirCvs(in.getRutaFitxer());
        

        

    }

    public LlegirCvs(String ruta){
        this.csvFileToRead = ruta;
        llegirCvs();
    }
    
    
    public void llegirCvs(){
        //Intermediari inter = new Intermediari();
        //String csvFileToRead = inter.getRutaFitxer();
        
        //String csvFileToRead = "C:\\Users\\MrSingh\\Documents\\NetBeansProjects\\LlegirCvs\\FitxerPerLlegir\\assig. matriculats.csv";
        BufferedReader br = null;
        String linia = "";
        String[] tLinia = null;

        try {
            
            br = new BufferedReader(new FileReader(csvFileToRead));

            while ((linia = br.readLine()) != null) {
                if (!linia.trim().startsWith("#") && !linia.isEmpty()) {
                    tLinia = linia.split("\"[A-Za-z,]\""); // elimina el numero+, del començament de la linia; split busca un numero(10,100,1000) seguit de una ,

                    crearLlistatMateriesAlumnes(extreureLlistatAlumnes(tLinia[0]), extreureLlistatMateries(tLinia[2]));

                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        } finally { //tanca el fitxer
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nFi del fitxer");
        }
    }

    public String[] mostrarMateries(){
       int z = 0;
        String[] llistaMateries = null;
        llistaMateries = new String[getLlistaMateriesAlumnes().size()];
        
        Set set = getLlistaMateriesAlumnes().entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            llistaMateries[z] = me.getKey().toString();
            z++;
        }
        return llistaMateries;
    }
    
    /**
     * agafa la string que se li passa que te caracters, numeros i el nom i
     * retorna nomes el nom,sense numeros ni caracters.
     *
     * @param alumne obtingut amb el split
     * @return alumne,sense numeros
     */
    public Alumne extreureLlistatAlumnes(String alumne) {
        String[] tAlumne;
        String alumnes;
        Alumne alum;

        alumnes = alumne.replaceAll("[0-9]+,\"", "");
        tAlumne = alumnes.split(",");

        alum = new Alumne(tAlumne[0], tAlumne[1]);

        return alum;
    }

    /**
     * agafa la materia i treu els numeros,commes,caracters extranys que no es
     * necessiten
     *
     * @param materia
     * @return String de materies
     */
    public String[] extreureLlistatMateries(String materia) {
        String[] tMateries;
        materia = materia.replace("\"", "");
        tMateries = materia.split(",");

        return tMateries;
    }

    /**
     * crea una treemap on la key es el nom de la materia i el value el llistat
     * de alumnes que fan aquesta materia.
     *
     * @param alumne
     * @param materia
     */
    public void crearLlistatMateriesAlumnes(Alumne alumne, String[] materia) { //em dona repetits per aixo hi ha el primer if.
        
        SortedSet<String> llistatAlumnes;

        if (!alumne.equals("0") || !materia.equals("0")) {
            for (int i = 0; i < materia.length; i++) {
                if (!llistaMateriesAlumnes.containsKey(materia[i])) { //no existeix la materia, la crea.
                    llistatAlumnes = new TreeSet<String>();
                    llistatAlumnes.add(alumne.getCognom().concat(alumne.getNom()));
                    getLlistaMateriesAlumnes().put(materia[i], llistatAlumnes);

                } else {
                    getLlistaMateriesAlumnes().get(materia[i]).add(alumne.getCognom().concat(alumne.getNom())); //recupero els valors de la treemap i faig un add.
                }

            }
        }
    }

    /**
     * @return arraylist de llistaMateriesAlumnes
     */
    public TreeMap<String, SortedSet> getLlistaMateriesAlumnes() {
        return llistaMateriesAlumnes;
    }

    /**
     * @param llistaMateriesAlumnes the llistaMateriesAlumnes to set
     */
    public void setLlistaMateriesAlumnes(TreeMap<String, SortedSet> llistaMateriesAlumnes) {
        this.llistaMateriesAlumnes = llistaMateriesAlumnes;
    }

}
