
public class Evento {

	private TipoEvento tipoEvento;
	private double tempo;
	private Fila fila;
	
	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public Evento(TipoEvento tipoEvento, double tempo, Fila fila) {
		this.tipoEvento = tipoEvento;
		this.tempo = tempo;
		this.fila = fila;
	}
	
	public TipoEvento getTipoEvento() { return this.tipoEvento; }
	
	public double getTempo() { return this.tempo; }
}
