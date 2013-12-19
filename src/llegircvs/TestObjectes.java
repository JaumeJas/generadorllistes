
import java.util.ArrayList;
import java.util.Arrays;

public class TestObjectes {
	// Creem objecte Alumne OK
	// Crear objecte materia OK
	// Passar-hi Alumnes OK
	// ORDENAR: Alumnes OK Assignatures OK

	public static void main(String[] args) {

		// Array alumnes
		Alumne[] alumnesArray = { new Alumne("Jaume", "Soler", "2DAM"),
				new Alumne("Andreu", "Solà", "2DAM"),
				new Alumne("Maria", "Solà", "2DAM"),
				new Alumne("Jaume", "Andreu", "2DAM"),
				new Alumne("Jaume", "Mir", "2DAM") };

		//Alumnes individuals
		Alumne alumne1 = new Alumne("Andreu", "Soler", "1DAM");
		Alumne alumne2 = new Alumne("Marte", "Jas", "10DAM");
		Alumne alumne3 = new Alumne("Jaume", "Jas", "5DAM");
		Alumne alumne4 = new Alumne("Anna", "Soler", "4DAM");
		Alumne alumne5 = new Alumne("Gim", "Soler", "5DAM");

		//Array materies
		Materia[] materiesArray = { new Materia("ZZAT", alumnesArray),
				new Materia("MAT", alumnesArray), new Materia("GAT", alumnesArray),
				new Materia("ZAT", alumnesArray), new Materia("ZAT", alumnesArray) };

		//Materies individuals
		Materia materies1 = new Materia("ZZAT", alumnesArray);
		Materia materies2 = new Materia("MAT", alumnesArray);
		Materia materies3 = new Materia("GAT", alumnesArray);
		Materia materies4 = new Materia("ZAT", alumnesArray);
		Materia materies5 = new Materia("ZAT", alumnesArray);

		//ArrayList de Materia i afegim materies
		ArrayList<Materia> materies = new ArrayList<Materia>();
		materies.add(materies1);
		materies.add(materies2);
		materies.add(materies3);
		materies.add(materies4);
		materies.add(materies5);

		//Ordenem materiesArray
		Arrays.sort(materiesArray);

		System.out.println("Llista Materies:");
		for (Materia m : materies) {
			System.out.println(m);
		}

		System.out.println("Llista Materies ordenada:");
		for (Materia m : materiesArray) {
			System.out.println(m);
		}
		
		//ArrayList d'alumnes i afegim alumnes
		ArrayList<Alumne> llistaAlumnes = new ArrayList<Alumne>();

		llistaAlumnes.add(alumne1);
		llistaAlumnes.add(alumne2);
		llistaAlumnes.add(alumne3);
		llistaAlumnes.add(alumne4);
		llistaAlumnes.add(alumne5);

		//ArrayList<Alumne[]> llistaAlumnesOrdenada = new ArrayList<Alumne[]>();
		Arrays.sort(alumnesArray);

		System.out.println("Llista alumnes:");
		for (Alumne p : llistaAlumnes) {
			System.out.println(p);
		}

		System.out.println("Llista alumnes ordenada:");
		for (Alumne p : alumnesArray) {
			System.out.println(p);
		}

		//System.out.println(materies.toString());
		//System.out.println(alumnes[1].toString());
	}
	// ArrayList<Alumne> llista1 = new ArrayList<Alumne>();

}
