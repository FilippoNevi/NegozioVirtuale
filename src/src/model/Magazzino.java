package model;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import model.PersonaleAutorizzato.PersonaleAutorizzatoBuilder;
import view.MainFrame;

public class Magazzino implements Serializable{		//pattern singleton
	
	private Map<Disco, Integer> magazzino;		//Disco, Occorrenze
	private List<Utente> utenti;
	private List<Artista> artisti;
	private List<Carrello> carrelli;
	
	private static final String FILE_PATH = "DB/codice_disco.txt";
	
	public Magazzino(){
		magazzino = new HashMap<>();
		utenti = new ArrayList<>();
		carrelli = new ArrayList<>();
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
    		
    		PrintWriter fOut = new PrintWriter(new FileWriter(FILE_PATH));
    		fOut.println(String.valueOf(Disco.getCodice()));
    		
    		fOut.close();    		
    		
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
	
	public void incDisco(Disco disco, int occorrenze){
		int pezzi = magazzino.get(disco);
		pezzi += occorrenze;
		magazzino.put(disco, pezzi);
	}
	
	public Carrello getCarrello(Cliente c){
		for (Carrello carrello : carrelli){
			if (carrello.getCliente().equals(c)){
				return carrello;
			}
		}
		return null;
	}
	
	public void addCarrello(Carrello carrello){
		carrelli.add(carrello);
	}
	
	public boolean containsCarrello(Carrello c){
		return carrelli.contains(c);
	}
	
	public static Magazzino loadMagazzino() throws ClassNotFoundException, IOException{
		
		File db = new File("./DB/magazzino.obj");
		File txt = new File("./DB/codice_disco.txt");
		if (!db.exists() || !txt.exists()){
			System.out.println("Creazione database in corso... ");
			Magazzino m = new Magazzino();
			
			PersonaleAutorizzato.PersonaleAutorizzatoBuilder builder = new PersonaleAutorizzatoBuilder("ADMIN", "admin", "admin");
			m.addUtente(builder.build());
			
			m.salva();
			return m;
		}
		
		BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
		String line = br.readLine();
		if (line != null){
			Disco.setCodice(Integer.parseInt(line));
		}
		
		br.close();
		
		FileInputStream fileIn = new FileInputStream("DB/magazzino.obj");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		Magazzino magazzino = (Magazzino) in.readObject();

		in.close();
		fileIn.close();
		return magazzino;
		
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException{

		Magazzino magazzino = Magazzino.loadMagazzino();		
		
		MainFrame frame = new MainFrame("Negozio virtuale", magazzino);
	}
}
