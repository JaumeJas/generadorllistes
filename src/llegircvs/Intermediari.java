/**
 * tots els metodes que necessitem per manipular la controlador-vista i que no haurien de estar en
 * crearXML o LlegirCvs...
 */

package llegircvs;

import gui.F_Gui;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MrSingh
 */
public class Intermediari {
    private LlegirCvs llegir ;
    private String rutaFitxer = "";
    private String[] llistaMateries=null;
//    F_Gui gui = new F_Gui();
    
    public Intermediari(){
        //llegir = new LlegirCvs();
    }
    
   
    /**Metode que nomes treu les keys de la treemap i crea un altre string per pogue enviarli a la gui que el mostrara.
     * @return llistat de les materies.
     */
    public String[] mostrarMateries(){
       int z = 0;
        
        llistaMateries = new String[llegir.getLlistaMateriesAlumnes().size()];
        
        Set set = llegir.getLlistaMateriesAlumnes().entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            llistaMateries[z] = me.getKey().toString();
            z++;
        }
        return llistaMateries;
    }

    /**
     * @return the rutaFitxer
     */
    public String getRutaFitxer() {
        return rutaFitxer;
    }

    /**
     * @param rutaFitxer the rutaFitxer to set
     */
    public void setRutaFitxer(String rutaFitxer) {
        this.rutaFitxer = rutaFitxer;
    }

    /**
     * @return the llistaMateries
     */
    public String[] getLlistaMateries() {
        return llistaMateries;
    }

    /**
     * @param llistaMateries the llistaMateries to set
     */
    public void setLlistaMateries(String[] llistaMateries) {
        this.llistaMateries = llistaMateries;
    }
    
    
}
