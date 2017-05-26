package model;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import view.MainFrame;

public class Magazzino implements Serializable{
	
	private Map<Disco, Integer> magazzino;		//Disco, Occorrenze
	private List<Utente> utenti;
	private List<Artista> artisti;
	private Map<Cliente, List<Disco>> vendite;
	
	public Magazzino(){
		magazzino = new HashMap<>();
		utenti = new ArrayList<>();
		vendite = new HashMap<>();
		artisti = new ArrayList<>();
	}
	
	public int getOccorrenza(Disco disco){
		return magazzino.get(disco);
	}
	
	public void insertDisco(Disco disco, int occorrenza){
		if (magazzino.containsKey(disco)){
			int num = getOccorrenza(disco);
			
			magazzino.put(disco, num + occorrenza);
		}
		else{
			magazzino.put(disco, occorrenza);
		}
	}
	
	public boolean addUtente(Utente u){
		if (utenti.contains(u))
			return false;
	
		utenti.add(u);
		return true;
	}
	
	public Utente getUtente(String codiceFiscale){
		for (Utente u : utenti){
			if (u.getCodiceFiscale().equals(codiceFiscale))
				return u;
		}
		return null;
	}
	
	public boolean acquista(Utente utente, Disco disco){
		
		if (magazzino.containsKey(disco)){
				
			int occorrenza = magazzino.get(disco);
			if (occorrenza > 0){		//Se ci sono dischi disponibili
				
				occorrenza--;
				
				magazzino.put(disco, occorrenza);
				return true;
			}			
		}
		return false;
	}
	
	public void addVendita(Cliente cliente, Disco disco){
		
		if (vendite.containsKey(cliente)){		//Se il cliente ha gia fatto acquisti
			List<Disco> acquisti = vendite.get(cliente);
			acquisti.add(disco);
		}
		else{			//Se il cliente è "nuovo"
			List<Disco> acquisti = new ArrayList<>();
			acquisti.add(disco);
			vendite.put(cliente, acquisti);
		}
	}
	
	public Utente getUtente(String username, String password){
		for (Utente u : utenti){
			if (u.getUsername().equals(username) && u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}
	
	public List<OccorrenzeDisco> getCatalogo(Comparator<Disco> comparator){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = magazzino.keySet();
		
		Disco[] dischi = new Disco[chiavi.size()];
		
		dischi = chiavi.toArray(dischi);
		
		Arrays.sort(dischi, comparator);
		
		for (Disco d : dischi){
			catalogo.add(new OccorrenzeDisco(d, magazzino.get(d)));
		}
		
		return catalogo;
	}
	public List<OccorrenzeDisco> getCatalogo(){
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		Set<Disco> chiavi = magazzino.keySet();
		
		for (Disco d : chiavi){
			catalogo.add(new OccorrenzeDisco(d, magazzino.get(d)));
		}
		
		return catalogo;
	}
	
	//Utile per sapere il genere "preferito" del cliente
	public Disco getUltimoAcquisto(Cliente cliente){
				
		if (vendite.containsKey(cliente)){
			List<Disco> acquisti = vendite.get(cliente);
			
			return acquisti.get(acquisti.size()-1);
		}
		
		return null;
		
	}
	
	public boolean addArtista(Artista artista){
		if (artisti.contains(artista))
			return false;
		
		artisti.add(artista);
		return true;
	}
	
	public List<Artista> getArtisti(){
		return artisti;
	}
	
	public List<Musicista> getMusicisti(){
		
		List<Musicista> musicisti = new ArrayList<>();
		for (Artista a : artisti){
			if (a instanceof Musicista)
				musicisti.add((Musicista)a);
		}
		return musicisti;
	}
	public List<OccorrenzeDisco> cercaPerGenere(Generi genere){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = magazzino.keySet();
		
		for (Disco disco : chiavi){
			if (disco.getGenere().equals(genere)){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									magazzino.get(disco)));
			}
		}
		
		return catalogo;
	}
	public List<OccorrenzeDisco> cercaPerTitolare(String titolare){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = magazzino.keySet();
		
		for (Disco disco : chiavi){
			if (disco.getTitolare().equals(titolare)){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									magazzino.get(disco)));
			}
		}
		
		return catalogo;
	}
	
	public List<OccorrenzeDisco> cercaPerPartecipante(String partecipante){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = magazzino.keySet();
		
		for (Disco disco : chiavi){
			if (disco.partecipa(partecipante)){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									magazzino.get(disco)));
			}
		}
		
		return catalogo;
	}
	
	public List<OccorrenzeDisco> cercaPerPrezzo(double prezzo){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = magazzino.keySet();
		
		for (Disco disco : chiavi){
			if (disco.getPrezzo() == prezzo){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									magazzino.get(disco)));
			}
		}
		
		return catalogo;
	}
	
	public void salva(){
		//una volta finite tutte le interazioni...  salvo su file
		System.err.println("Salvataggio dati...");
	
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("DB/magazzino.obj");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
    		out.writeObject(this);
    		out.close();
    		fileOut.close();
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public Artista getArtista(String nome){
		for (Artista artista : artisti){
			if (artista.getNomeArte().equals(nome))
				return artista;
		}
		return null;
	}
	
	public void addDisco(Disco disco, int occorrenze){
		magazzino.put(disco, occorrenze);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException{

		//new Magazzino().salva();
		FileInputStream fileIn = new FileInputStream("DB/magazzino.obj");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		Magazzino magazzino = (Magazzino) in.readObject();
		//magazzino.addUtente(new PersonaleAutorizzato("ADMIN", "admin", "admin", "admin", "admin", "admin", "0376", "347"));
		in.close();
		fileIn.close();
		
		magazzino.addUtente(new PersonaleAutorizzato("ADMIN", "admin", "admin", "Admin", "Admin", "Ufficio", "0376", "347"));
		
		MainFrame frame = new MainFrame("Negozio virtuale", magazzino);
		System.out.println(magazzino.magazzino);
		
	}
}
