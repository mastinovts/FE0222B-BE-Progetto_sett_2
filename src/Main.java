import java.util.Scanner;

import Blog.Articolo;
import Blog.ArticoloFantasy;
import Blog.ArticoloNoir;
import Blog.Autore;
import Blog.BlogImp;
import Blog.Tags;

public class Main {

	public static void main(String[] args) {
		Autore autore = new Autore(1, "Rosario", "Sciacquetta");
		Autore autore1 = new Autore(2, "Antonio", "Bulletta");
		
		Articolo articolo1 = autore.scriviArticolo("La tua bestemmia quotidiana",
				"Comico", "Fai partire al meglio la tua giornata con Le 365 migliori " + 
						"bestemmie per Calmare la rabbia e Ridurre lo stress", new Tags(new String[] {"Comico", "irriverente", "Fantascienza"}));
		
		Articolo articolo2 = autore.scriviArticolo("Padre ricco padre povero",
				"Motivazionale", "Dimostrare ai genitori che il sistema scolastico non fornisce una preparazione economico-finanziaria "
						+ "e spiegare una volta per tutte la differenza tra attivi e passivi", new Tags(new String[] {"Contemporaneo", "Accidenti"}));
		
		Articolo articolo3 = new ArticoloFantasy(0, "Sticazzi. La suprema via della leggerezza",
				"Sticazzi è l’antica e potente formula che da secoli permette di distaccarsi dalle gravose " 
						+ "pesantezze del quotidiano e percorrere la suprema via della leggerezza.", new Tags(new String[] {"Fantascienza","Incredibile","Vero"}));
		
		Articolo articolo4 = new ArticoloNoir(0, "Apocalisse",
				"Il Sistema non può essere messo in discussione e, nella mente di tutti, deve rappresentare " 
						+ "il migliore dei mondi possibili. Per questo ha imparato a distogliere l'attenzione creando di volta "
						+ "in volta un nemico da combattere, che in questo caso è il virus.", new Tags(new String[] {"Giallo", "Drammatico"}));
		
		
		autore1.scriviArticolo(articolo3);
		autore1.scriviArticolo(articolo4);

		Articolo[] articoli = {articolo1, articolo2, articolo3, articolo4};
		
		BlogImp Blog = new BlogImp(articoli);
		
		
		System.out.println("Presenti in biblioteca " + Blog.getArticoli().length + " libri interessanti");
		
		
		
		Scanner scanner = new Scanner(System.in);
		if(Blog.getArticoli().length != 0) {
			
			int input = -1;

			do {
				System.out.println("Premi 0, 1 o 2 per:\n0- Stampa tutti gli articoli"
						+ "\n1- Stampa articolo per ID\n2- Termina processo");
				input = Integer.parseInt(scanner.nextLine());

				if(input == 0) {
					System.out.println(Blog.stampaArticoli());
				} else if(input == 1) {
					System.out.println("Inserisci l'id dell articolo scelto");
					int id = Integer.parseInt(scanner.nextLine());
					do {
						if(!idEsiste(id, Blog)) {
							System.out.println("Non esistono articoli con questo id");
							break;
						} else {
							System.out.println(Blog.stampaArticoloPerId(id));
						}
					} while (!idEsiste(id, Blog));
					
				}
			}while(input != 0 && input != 1 && input != 2);
		} else {
			System.out.println("Non ci sono articoli nel blog");
		}
	}

	static boolean idEsiste(int id, BlogImp blog) {
		boolean trovato = false;
		for(int i=0; i<blog.getArticoli().length && !trovato; i++) {
			if(blog.getArticoli()[i].getId() == id) {
				trovato = true;
			}
		}
		return trovato;
	}
}
