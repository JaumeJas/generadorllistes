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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author MrSingh
 */
public class LlegirCvs {

    //TreeSet llistaMateries = new TreeSet();  //guardo les materies ordenades i sense duplicacions
    TreeMap<String,List> llistaMateriesAlumnes = new TreeMap<String,List>();

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

                while ((linia = br.readLine()) != null) {
                    if (!linia.trim().startsWith("#")) {
                        tLinia = linia.split("\"[A-Za-z,]\""); // elimina el numero+, del començament de la linia; split busca un numero(10,100,1000) seguit de una ,

                        crearLlistatMateriesAlumnes(extreureLlistatAlumnes(tLinia[0]), extreureLlistatMateries(tLinia[2]));
                        System.out.println(llistaMateriesAlumnes);
                    }
                }
                Set set = llistaMateriesAlumnes.entrySet();
                Iterator i = set.iterator();
                while (i.hasNext()){
                    Map.Entry me = (Map.Entry) i.next();
                    System.out.println(me.getKey() + " : "+me.getValue());
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

    public String extreureLlistatAlumnes(String alumne) {
        String[] tAlumnes;
        alumne = alumne.replace(",", "");
        tAlumnes = alumne.split("^\\d+\"");

        for (int i = 0; i < tAlumnes.length; i++) {
            if (!tAlumnes[i].trim().isEmpty()) { //com que guarda espais.
                return tAlumnes[i];
            }
        }
        return "0";
    }

    public String[] extreureLlistatMateries(String materia) {
        String[] tMateries;
        String ola = "";
        materia = materia.replace("\"", "");
        tMateries = materia.split(",");

        for (int i = 0; i < tMateries.length; i++) {
            ola = ola + " " + tMateries[i];
            //llistaMateries.add(tMateries[i]); //era per afegir el llistat a la interficia
            //System.out.println(tMateries[i]);

        }
        return tMateries; //les materies surten duplicades perque  no es un map,

        //escriu
        /*Iterator iterator = llistaMateries.iterator();
         while (iterator.hasNext()){
         System.out.println(iterator.next() + "<->");
         }*/
    }

    public void crearLlistatMateriesAlumnes(String alumne, String[] materia) { //em dona repetits hauria de utilitzar el treeset
        List l = new ArrayList();
        //new ArrayList(alumne)
        if (!alumne.equals("0") || !materia.equals("0")) {
            for (int i = 0; i < materia.length; i++) {
              /*  if (!llistaMateriesAlumnes.containsKey(materia[i])) { //no existeix la materia, la crea.
                    llistaMateriesAlumnes.put(materia[i], l.add(alumne));
                } else {
                    llistaMateriesAlumnes.put(llistaMateriesAlumnes.get(materia[i]), alumne);
                }*/

            }
        }
    }
}
