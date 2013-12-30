package llegircvs;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CrearXmlJDom {

    public static void main(String[] args) {

    }

    private String[] llistatMateries;

    public CrearXmlJDom(String[] llistaMateries) {
        this.llistatMateries = llistaMateries;

        crearElementRoot();

    }

    public void crearElementRoot() {

        Element llistes = new Element("llistes");
        Document doc = new Document(llistes);
		//doc.setRootElement(llistes);

        crearElement(llistatMateries, doc);
    }

    public void crearElement(String[] llistatMateries, Document doc) {

        for (int i = 0; i < llistatMateries.length; i++) {
            Element nom = new Element("llista");
            nom.setAttribute(new Attribute("materia", llistatMateries[i]));

            doc.getRootElement().addContent(nom);

            CrearElementAlumne(nom, doc, i /*paso arraylist perque recorri*/);
        }

    }

    private void CrearElementAlumne(Element nom, Document doc, int i /*paso arraylist perque recorri*/) {
        Element alumne = new Element("alumne");
        //afegeixo a llista la etiqueta alumne
        nom.addContent(alumne);
        //afegeixo a alumnela etiqueta cognomsNom i grup.
        alumne.addContent(new Element("cognomsNom").setText("/*aqui el nom del alumne*/"));
        alumne.addContent(new Element("grup").setText(llistatMateries[i]));

		//doc.getRootElement().addContent(alumne);
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter("prova.xml"));
        } catch (IOException e) { //error en escriure el fitxer

            e.printStackTrace();
        }
        System.out.println("Xml Creat");

    }
}
