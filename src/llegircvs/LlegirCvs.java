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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author MrSingh
 */
public class LlegirCvs {

    //TreeSet llistaMateries = new TreeSet();  //guardo les materies ordenades i sense duplicacions
    TreeMap<String, SortedSet> llistaMateriesAlumnes = new TreeMap<String, SortedSet>();
    

    public static void main(String[] args) {
        try {
            LlegirCvs l = new LlegirCvs();
            l.llegirCvs();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void llegirCvs() throws InterruptedException {
        String csvFileToRead = "C:\\Users\\MrSingh\\Documents\\NetBeansProjects\\LlegirCvs\\FitxerPerLlegir\\assig. matriculats.csv";
        BufferedReader br = null;
        String linia = "";

        try {
            String[] tLinia = null;
            try {
                br = new BufferedReader(new FileReader(csvFileToRead));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try {

                while ((linia = br.readLine()) != null ) {
                	if (linia.isEmpty()){	//si la linia es buida,nomes han fet enters,trenqui.
                		break;
                	}
                    if (!linia.trim().startsWith("#")) {
                        tLinia = linia.split("\"[A-Za-z,]\""); // elimina el numero+, del començament de la linia; split busca un numero(10,100,1000) seguit de una ,

                        crearLlistatMateriesAlumnes(extreureLlistatAlumnes(tLinia[0]), extreureLlistatMateries(tLinia[2]));
                        
                    }
                }
                
                //mostra per pantalla
                Set set = llistaMateriesAlumnes.entrySet();
                Iterator i = set.iterator();
                while (i.hasNext()) {
                    Map.Entry me = (Map.Entry) i.next();
                    System.out.println(me.getKey() + " : " + me.getValue());
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } finally { //tanca el fitxer
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\nFi del fitxer");

    }

    public Alumne extreureLlistatAlumnes(String alumne) { 
    	String[] tAlumne;
    	String alumnes;
    	Alumne alum;
    	
    	alumnes = alumne.replaceAll("[0-9]+,\"", "");	
        tAlumne = alumnes.split(",");
        
        alum = new Alumne(tAlumne[0], tAlumne[1]);
        
        
        
        return alum;
    }

    public String[] extreureLlistatMateries(String materia) {
        String[] tMateries;
        String ola = "";
        materia = materia.replace("\"", "");
        tMateries = materia.split(",");

        return tMateries; 
        
    }

    public void crearLlistatMateriesAlumnes(Alumne alumne, String[] materia) { //em dona repetits per aixo hi ha el primer if.
        //alumne es objecte, no string, perque els necessitarem mes endevant per el xml.
        
        SortedSet<String> llistatAlumnes;
        
        if (!alumne.equals("0") || !materia.equals("0")) {
            for (int i = 0; i < materia.length; i++) {
                  if (!llistaMateriesAlumnes.containsKey(materia[i])) { //no existeix la materia, la crea.
                      llistatAlumnes = new TreeSet<String>();
                      llistatAlumnes.add(alumne.getCognom().concat(alumne.getNom()));
                      llistaMateriesAlumnes.put(materia[i], llistatAlumnes);
                    
                 } else {
                      llistaMateriesAlumnes.get(materia[i]).add(alumne.getCognom().concat(alumne.getNom())); //recupero els valors de la treemap i faig un add.
                 }

            }
        }
    }
}
