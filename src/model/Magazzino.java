package model;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import model.PersonaleAutorizzato.PersonaleAutorizzatoBuilder;
import view.MainFrame;


/**
 * 
 * Classe che gestisce il magazzino di dischi. Essa memorizza le occorrenze dei dischi prensenti, 
 * l'insieme degli utenti registrati alla piattaforma, l'elenco di tutti gli artisti e band registrati
 * e contiene una struttura dati per memorizzare i carrelli dei vari utenti. 
 * 
 * Realizzata secondo il pattern: SINGLETON
 * 
 *
 */
public class Magazzino implements Serializable{	
	
	private Map<Disco, Integer> dischi;			//Contiene le occorrenze dei dischi in magazzino	
	private List<Utente> utenti;				//Contiene la lista di tutti gli utenti registrati alla piattaforma
	private List<Artista> artisti;				//Contiene la lista degli artisti salvati
	private List<Carrello> carrelli;			//Contiene i carrelli di tutti i clienti
	
	private static final String FILE_PATH = "DB/codice_disco.txt";		//Path in cui viene serializzato il magazzino
	public static final String IMG_PATH = "IMG/";
	
	private static Magazzino magazzino;
	
	
	/**
	 * Metodo costruttore che inizializza un Magazzino vuoto
	 */
	private Magazzino(){
		dischi = new HashMap<>();
		utenti = new ArrayList<>();
		carrelli = new ArrayList<>();
		artisti = new ArrayList<>();
	}
	
	/**
	 * Realizzazione del pattern singleton
	 */
	
	public static Magazzino getInstance() throws IOException, ClassNotFoundException{
		if (magazzino == null){
			magazzino = loadMagazzino();
		}
		return magazzino;
	}
	
	/**
	 * Metodo che ritorna le occorrenze in magazzino del disco
	 * @param disco Disco di cui si vuole conoscere l'occorrenza in magazzino
	 * @return
	 */
	public int getOccorrenza(Disco disco){
		return dischi.get(disco);
	}
	
	/**
	 * Metodo che consente l'inserimento di un nuovo utente nella struttura
	 * @param u Utente da inserire
	 * @return true se l'utente è stato inserito, false se è già presente nella struttura
	 */
	public boolean addUtente(Utente u){
		if (utenti.contains(u))
			return false;
	
		utenti.add(u);
		return true;
	}
	
	/**
	 * Metodo che ritorna l'utente a cui corrisponde un determinato codice fiscale
	 * @param codiceFiscale CF dell'utente da cercare
	 * @return Utente se è stato trovato, null altrimenti
	 */
	public Utente getUtente(String codiceFiscale){
		for (Utente u : utenti){
			if (u.getCodiceFiscale().equals(codiceFiscale))
				return u;
		}
		return null;
	}
	
	/**
	 * Metodo che decrementa l'occorrenza di un disco nella struttura. Avviene a causa di un acquisto
	 * (metodo per usi futuri)
	 * @param utente Utente che effettua l'acquisto
	 * @param disco Disco che si vuole acquistare
	 * @return true se ci sono dischi disponibili, false altrimenti 
	 */
	public boolean acquista(Utente utente, Disco disco){
		
		if (dischi.containsKey(disco)){
				
			int occorrenza = dischi.get(disco);
			if (occorrenza > 0){		//Se ci sono dischi disponibili
				
				occorrenza--;
				
				dischi.put(disco, occorrenza);
				return true;
			}			
		}
		return false;
	}
	
	/**
	 * Metodo che restituisce l'utente a cui corrispondono username e password
	 * @param username Username dell'utente
	 * @param password Password dell'utente
	 * @return Utente se username e password sono corretti, null altrimenti
	 */
	public Utente getUtente(String username, String password){
		for (Utente u : utenti){
			if (u.getUsername().equals(username) && u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}
	
	/**
	 * Metodo che ritorna il catalogo di dischi presenti in memoria. Ritorna per ogni disco, la sua occorrenza	
	 * @param comparator Comparator che consente di ordinare il risultato
	 * @return Catalogo di dischi ordinato
	 */
	public List<OccorrenzeDisco> getCatalogo(Comparator<Disco> comparator){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = dischi.keySet();
		
		Disco[] cds = new Disco[chiavi.size()];
		
		cds = chiavi.toArray(cds);
		
		Arrays.sort(cds, comparator);
		
		for (Disco d : cds){
			catalogo.add(new OccorrenzeDisco(d, dischi.get(d)));
		}
		
		return catalogo;
	}
	
	/**
	 * Metodo che ritorna il catalogo di dischi presenti in memoria, non ordinandolo
	 * @return Catalogo di dischi
	 */
	public List<OccorrenzeDisco> getCatalogo(){
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		Set<Disco> chiavi = dischi.keySet();
		
		for (Disco d : chiavi){
			catalogo.add(new OccorrenzeDisco(d, dischi.get(d)));
		}
		
		return catalogo;
	}
	
	/**
	 * Metodo che aggiunge un artista alla struttura dati
	 * @param artista Artista da aggiungere
	 * @return true se l'artista è stato inserito, false se è già presente nella struttura
	 */
	public boolean addArtista(Artista artista){
		if (artisti.contains(artista))
			return false;
		
		artisti.add(artista);
		return true;
	}
	
	/**
	 * Ritorna la lista di tutti gli artisti salvati
	 * @return Lista artisti
	 */
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
	
	/**
	 * Metodo che ritorna i dischi che appartengono al genere inserito
	 * @param genere Genere musicale
	 * @return Lista dischi che corrispondono alla ricerca
	 */
	public List<OccorrenzeDisco> cercaPerGenere(Generi genere){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = dischi.keySet();
		
		for (Disco disco : chiavi){
			if (disco.getGenere().equals(genere)){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									dischi.get(disco)));
			}
		}
		
		return catalogo;
	}
	
	/**
	 * Metodo che ritorna i dischi relativi al titolare passato per parametro
	 * @param titolare Titolare del disco
	 * @return Lista dischi che corrispondono alla ricerca
	 */
	public List<OccorrenzeDisco> cercaPerTitolare(String titolare){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = dischi.keySet();
		
		for (Disco disco : chiavi){
			if (disco.getTitolare().equals(titolare)){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									dischi.get(disco)));
			}
		}
		
		return catalogo;
	}

	/**
	 * Metodo che ritorna i dischi che hanno come partecipante il musicista passato in input
	 * @param partecipante Partecipante del disco
	 * @return Lista dischi che corrispondono alla ricerca
	 */
	public List<OccorrenzeDisco> cercaPerPartecipante(String partecipante){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = dischi.keySet();
		
		for (Disco disco : chiavi){
			if (disco.partecipa(partecipante)){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									dischi.get(disco)));
			}
		}
		
		return catalogo;
	}
	
	/**
	 * Metodo che ritorna i dischi che hanno come prezzo quello passato come parametro
	 * @param prezzo Prezzo da cercare
	 * @return Lista dischi che corrispondono alla ricerca
	 */
	public List<OccorrenzeDisco> cercaPerPrezzo(double prezzo){
		
		List<OccorrenzeDisco> catalogo = new ArrayList<>();
		
		Set<Disco> chiavi = dischi.keySet();
		
		for (Disco disco : chiavi){
			if (disco.getPrezzo() == prezzo){
				catalogo.add(new OccorrenzeDisco(
									disco, 
									dischi.get(disco)));
			}
		}
		
		return catalogo;
	}
	
	/**
	 * Metodo che serializza i dati su disco
	 */
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
	
	/**
	 * Metodo che ritorna l'artista che possiede un determinato nome	
	 * @param nome Nome dell'artista
	 * @return Artista che ha quel nome (se presente), null altrimenti
	 */
	public Artista getArtista(String nome){
		for (Artista artista : artisti){
			if (artista.getNomeArte().equals(nome))
				return artista;
		}
		return null;
	}
	
	/**
	 * Mertodo che aggiunge un nuovo disco in memoria
	 * @param disco Disco da inserire
	 * @param occorrenze Occorrenze del disco
	 */
	public void addDisco(Disco disco, int occorrenze){
		dischi.put(disco, occorrenze);
	}
	
	/**
	 * Incrementa il disco inserito di occorrenze
	 * @param disco Disco da aggiungere 
	 * @param occorrenze Occorrenze del disco
	 */
	public void incDisco(Disco disco, int occorrenze){
		int pezzi = dischi.get(disco);
		pezzi += occorrenze;
		dischi.put(disco, pezzi);
	}
	
	/**
	 * Metodo che ritorna il carrello relativo al cliente
	 * @param c Cliente del carrello
	 * @return Il carrello del cliente, se esiste. Null altrimenti
	 */
	public Carrello getCarrello(Cliente c){
		for (Carrello carrello : carrelli){
			if (carrello.getCliente().equals(c)){
				return carrello;
			}
		}
		return null;
	}
	
	
	/**
	 * Metodo per aggiungere un nuovo carrello alla struttura dati
	 * @param carrello Carrello da aggiungere
	 */
	public void addCarrello(Carrello carrello){
		if (carrelli.contains(carrello)){
			carrelli.remove(carrello);
			carrelli.add(carrello);
		}
		else
			carrelli.add(carrello);
		System.err.println("numero carrelli : "+carrelli.size());
	}
	
	/**
	 * Metodo che controlla se esiste in memoria quel determinato carrello
	 * @param c Carrello da cercare
	 * @return true se esiste, false altrimenti
	 */
	
	public boolean containsCarrello(Carrello c){
		return carrelli.contains(c);
	}
	
	/**
	 * Metodo statico che consente di caricare dalla memoria un nuovo magazzino e ritornarlo al chiamante
	 * 
	 */
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
	
	/**
	 * Metodo main del programma
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException{

		Magazzino magazzino = Magazzino.loadMagazzino();		
		
		MainFrame frame = new MainFrame("Negozio virtuale", magazzino);
	}
}
