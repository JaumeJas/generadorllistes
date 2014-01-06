package llegircvs;

import gui.F_Gui;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CrearXmlJDom {

    private String[] llistatMateries;
    private String rutaF = "";

    public CrearXmlJDom() {

    }

    public CrearXmlJDom(String[] llistaMateries) {
        this.llistatMateries = llistaMateries;

        crearElementRoot();

    }

    public CrearXmlJDom(String[] llistaMateries, String file) {
        this.llistatMateries = llistaMateries;
        this.rutaF = file;
        comprobarRutaFitxer();
        crearElementRoot();
    }

    public void comprobarRutaFitxer() {
        if (!rutaF.contains(".")) {
            rutaF = rutaF + ".xml";
        }
    }

    public void crearElementRoot() {

        Element llistes = new Element("llistes");
        Document doc = new Document(llistes);

        crearElement(llistatMateries, doc);
    }

    public void crearElement(String[] llistatMateries, Document doc) {

        String[] prova;

        for (int i = 0; i < llistatMateries.length; i++) {

            Element nom = new Element("llista");
            nom.setAttribute(new Attribute("materia", llistatMateries[i]));

            doc.getRootElement().addContent(nom);

            //necessito accedir la variable LlegirCvs de F_gui i tirar el metode llistaAlumnes...no puc fer new aqui.
            //que es comparteixi la instance sino no es la mateixa instancia(la de la gui i el new de aqui.)
            //tinc que fer getInstance i despres treballar sobre aixo.
            prova = F_Gui.getCvs().llistarAlumnes(llistatMateries[i]);
            CrearElementAlumne(nom, doc, i, prova);
        }
    }

    public void CrearElementAlumne(Element nom, Document doc, int i, String[] nomAlumne) {

        for (int z = 0; z < nomAlumne.length; z++) {
            Element alumne = new Element("alumne");

            //afegeixo a llista la etiqueta alumne
            nom.addContent(alumne);
            //afegeixo a alumne la etiqueta cognomsNom i grup.
            alumne.addContent(new Element("cognomsNom").setText(nomAlumne[z]));
            alumne.addContent(new Element("grup").setText(llistatMateries[i]));
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter(rutaF));
        } catch (IOException e) { //error en escriure el fitxer

            e.printStackTrace();
        }
    }

    /**
     * @return the llistatMateries
     */
    public String[] getLlistatMateries() {
        return llistatMateries;
    }

    /**
     * @param llistatMateries the llistatMateries to set
     */
    public void setLlistatMateries(String[] llistatMateries) {
        this.llistatMateries = llistatMateries;
    }

}
