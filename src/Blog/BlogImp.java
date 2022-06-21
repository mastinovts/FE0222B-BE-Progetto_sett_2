package Blog;

import java.text.DateFormat;
import java.util.Locale;

public class BlogImp implements Blog{
	private Articolo[] articoli;

	public BlogImp() {}
	
	public BlogImp(Articolo[] articoli) {
		setArticoli(articoli);
	}

	public Articolo[] getArticoli() {
		return articoli;
	}

	public void setArticoli(Articolo[] articoli) {
		this.articoli = articoli;
		for(int i=0; i<articoli.length; i++) {
			articoli[i].setId(i+1);
		}
	}

	@Override
	public String stampaArticoloPerId(int id) {
		String msg = "Non esiste alcun articolo con questo id";
		boolean trovato = false;
		if(articoli != null) {
			
			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
			
			for(int i=0; i<articoli.length && !trovato; i++) {
				if(articoli[i].getId() == id) {
					
					msg = "\n***************\n" +
							"Articolo  " + id +
							"\n\nTitolo: " + articoli[i].getTitolo() +
							"\nData inserimento: " + df.format(articoli[i].getData()) +
							"\nCategoria: " + articoli[i].getCategoria() +
							"\nTesto: " + articoli[i].getTesto() +
							"\nAutore: " + articoli[i].getAutore() +
							"\nTags: " + articoli[i].getTags(); 
							
					if(articoli[i] instanceof ArticoloFantasy) {
						msg += "\nDescrizione: " + ((ArticoloFantasy)articoli[i]).getDescrizione();
					} else if(articoli[i] instanceof ArticoloNoir) {
						msg += "\nDescrizione: " + ((ArticoloNoir)articoli[i]).getDescrizione();
					} else {
						msg += "\n";
					}
					trovato = true;
					
				}
			}
		}
		return msg;
	}

	@Override
	public String stampaArticoli() {
		
		String msg = "Non esiste alcun articolo con questo id";
		if(articoli != null) {
			msg = "";
			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
			for(int i=0; i<articoli.length; i++) {
				msg += "\n***************\n" +
						"Articolo con id " + articoli[i].getId() +
						"\n\nTitolo: " + articoli[i].getTitolo() +
						"\nData inserimento: " + df.format(articoli[i].getData()) +
						"\nCategoria: " + articoli[i].getCategoria() +
						"\nTesto: " + articoli[i].getTesto() +
						"\nAutore: " + articoli[i].getAutore() +
						"\nTags: " + articoli[i].getTags();
						
				if(articoli[i] instanceof ArticoloFantasy) {
					msg += "\nDescrizione: " + ((ArticoloFantasy)articoli[i]).getDescrizione() +"\n***************\n";
				} else if(articoli[i] instanceof ArticoloNoir) {
					msg += "\nDescrizione: " + ((ArticoloNoir)articoli[i]).getDescrizione() +"\n***************\n";
				} else {
					msg += "\n";
				}
			}
		}
		return msg;
	}

}
