package logico;

public class Pitcher extends Jugador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float juegoGanado;
	private float juegoPerdido;
	private float carrerasLimpias;	 //ER EARNED RUNS 
	private float inningsLanzados; 
	private float ponches; 
	private float BB;
	private float juegosSalvados;
	public Pitcher(String nombre, String noDorsal, float cantJuegos, float errores, String equipo, boolean lesionado,
			float altura, float peso) {
		super(nombre, noDorsal, cantJuegos, errores, equipo, lesionado, altura, peso);

	}
	public float getCarrerasLimpias() {
		return carrerasLimpias;
	}
	public void setCarrerasLimpias(float carrerasLimpias) {
		this.carrerasLimpias = carrerasLimpias;
	}
	public float getJuegoGanado() {
		return juegoGanado;
	}
	public float getJuegoPerdido() {
		return juegoPerdido;
	}
	public float getEfectividad() {
		return carrerasLimpias;
	}
	public float getInningsLanzados() {
		return inningsLanzados;
	}
	public float getPonches() {
		return ponches;
	}
	public float getJuegosSalvados() {
		return juegosSalvados;
	}
	public void setJuegoGanado(float juegoGanado) {
		this.juegoGanado = juegoGanado;
	}
	public void setJuegoPerdido(float juegoPerdido) {
		this.juegoPerdido = juegoPerdido;
	}
	public void setEfectividad(float efectividad) {
		this.carrerasLimpias = efectividad;
	}
	public void setInningsLanzados(float inningsLanzados) {
		this.inningsLanzados = inningsLanzados;
	}
	public void setPonches(float ponches) {
		this.ponches = ponches;
	}
	public void setJuegosSalvados(float juegosSalvados) {
		this.juegosSalvados = juegosSalvados;
	}
	public float getBB() {
		return BB;
	}
	public void setBB(float bB) {
		BB = bB;
	}
	
	public  void insertarLesion(Lesion aux) {  
		misLesiones.add(aux);  
		lesionado = true;
	}
	
public float efectividad() { 
	float era=0; 
	return era = (getCarrerasLimpias()*9) / getInningsLanzados();
}
//@Override

//public void insertarLesion(String auxLesion) {
	 		  // misLesiones.add(auxLesion); }
	
}
