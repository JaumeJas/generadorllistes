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
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 *
 * @author MrSingh
 */
public class LlegirCvs {
    TreeSet llistaMateries= new TreeSet();  //guardo les materies ordenades i sense duplicacions
public static void main(String[] args) {
		LlegirCvs l = new LlegirCvs();
		l.llegirCvs();

	}
	
	public void llegirCvs() { 
		String csvFileToRead = "C:\\Users\\MrSingh\\Documents\\NetBeansProjects\\LlegirCvs\\FitxerPerLlegir\\assig. matriculats.csv";
		BufferedReader br = null;
		String linia = "";
		
		
		String splitBy = "^(\\d+),";	
		
                //([a-zA-Zìíòóñàáèéùú]+\\s?[a-zA-Zìíòóñàáèéùú]+[\\s|,|\\s]+[a-zA-Zìíòóñàáèéùú]+[\\s|,|\\s]*[a-zA-Zìíòóñàáèéùú?]+)
		Pattern patro_nomCognom = Pattern.compile("([A-Za-zìíòóñàáèéùú]+\\s?[a-zA-Zìíòóñàáèéùú]+[\\s|?,|\\s]+[a-zA-Zìíòóñàáèéùú]+[\\s|,|\\s]*[a-zA-Zìíòóñàáèéùú?]+)");
		Pattern patro_Classe = Pattern.compile("([1|2]?Batx[A|B|C]?)");
		Pattern patro_materies = Pattern.compile("\\\"([1-9|A-Z]{1}[A-Z]{2},?|([A-Z]{2},?|[1-9]{2},?)\\\"?)+\\\"");	
		Matcher matcher_NomCognom= null;
		Matcher matcher_classe = null;
		Matcher matcher_materies = null;
                
                
                
		try {
			
			br = new BufferedReader(new FileReader(csvFileToRead));
			while ((linia = br.readLine()) != null) {
				
				String[] tLinia = linia.split(splitBy); // elimina el numero+, del començament de la linia; split busca un numero(10,100,1000) seguit de una ,
				
				for (int i = 0; i < tLinia.length; i++) {
					matcher_NomCognom = patro_nomCognom.matcher(tLinia[i]);
					matcher_classe = patro_Classe.matcher(tLinia[i]);
					matcher_materies = patro_materies.matcher(tLinia[i]);
					if (matcher_NomCognom.find()){	//treu el nom
						if (matcher_classe.find()){	//treu el curs
                                                    
                                                    if (matcher_materies.find()){ //treu tot el conjunt de materies
                                                     //   System.out.println(matcher_materies.group());    
                                                        extreureLlistatMateries(matcher_materies.group()); //extreu el llista de totes les materies
							System.out.flush();
							System.out.println(matcher_NomCognom.group() + " <-> " + matcher_classe.group()+ " <-> "+matcher_materies.group() );
							
							}
						}
					}
			import java.util.Collections;	}
			}
                       // System.out.println(llistaMateries); 
                
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
	private void extreureLlistatMateries(String group) {
                //hauria de retallar la llista de les materies per la ,
                llistaMateries.add(group);
		
		
		
	}
    
}
