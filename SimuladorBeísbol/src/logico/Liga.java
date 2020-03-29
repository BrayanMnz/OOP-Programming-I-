package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;





public class Liga implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Jugador> misJugadores;
	private ArrayList <Equipo> misEquipos;
	private ArrayList <Partido> misPartidos; 
	private static Liga miLiga;
	
	public Liga() {
		misJugadores = new ArrayList<Jugador>();
		misEquipos = new ArrayList<Equipo>();
	    misPartidos = new ArrayList<Partido>();
		
	}
	public static Liga getInstance() { 
		  if(miLiga==null) { 
			  miLiga = new Liga();
		  }
		return miLiga;
	}

	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}
	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}
	public static Liga getMiLiga() {
		return miLiga;
	}
	public static void setMiLiga(Liga miLiga) {
		Liga.miLiga = miLiga;
	}
	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}
	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}
	
	//Metodos para insertar
	public  void insertarEquipo(Equipo aux) {  
		getMisEquipos().add(aux);  
	}
	public void insertarJugador(Jugador aux) { 
		misJugadores.add(aux);
	} 
	public void insertarPartido(Partido aux) { 
		misPartidos.add(aux);
	}
	//Buscar Equipo 
	 public Equipo buscarEquipoById (String idEquipo) { 
   	 boolean encontrado = false; 
   	Equipo auxEquipo =null;
   	 int i=0;
   	 while(i<getMisEquipos().size() && !encontrado) {
   		 if(getMisEquipos().get(i).getId().equalsIgnoreCase(idEquipo)) {
   			 auxEquipo = getMisEquipos().get(i);
   			 encontrado = true; 
   			
   		 } i++;  
   		 }
		return  auxEquipo;
	 }
	 public Equipo buscarEquipoByName (String NameEquipo) { 
    	 boolean encontrado = false; 
    	Equipo auxEquipo =null;
    	 int i=0;
    	 while(i<getMisEquipos().size() && !encontrado) {
    		 if(getMisEquipos().get(i).getNombreEquipo().equalsIgnoreCase(NameEquipo)) {
    			 auxEquipo = getMisEquipos().get(i);
    			 encontrado = true; 
    			
    		 } i++;  
    		 }
		return  auxEquipo;
	 }
	 
	 
	 
	
	// para guardar los datos de la clase controladora
	public void guardarDatos(Liga miLiga) {
		File file = new File("DatosLiga.dat");
		FileOutputStream fileOutput;
		ObjectOutputStream fileObjectOutput = null;

		try {
			fileOutput = new FileOutputStream(file);
			fileObjectOutput = new ObjectOutputStream(fileOutput);
			fileObjectOutput.writeObject(miLiga);

			fileOutput.close();
			fileObjectOutput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileObjectOutput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void cargarLiga(Liga miLiga) {

		File file = new File("DatosLiga.dat");
		FileInputStream fileInput;
		ObjectInputStream fileObjectInput;

		try {
			fileInput = new FileInputStream (file);
			fileObjectInput = new ObjectInputStream(fileInput);

			Liga mlb = (Liga) fileObjectInput.readObject();
			Liga.setMiLiga(mlb);
			fileInput.close();
			fileObjectInput.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
