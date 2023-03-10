
public class Evento {

	private TipoEvento tipoEvento;
	private double tempo;
	
	public Evento(TipoEvento tipoEvento, double tempo) {
		this.tipoEvento = tipoEvento;
		this.tempo = tempo;
	}
	
	public TipoEvento getTipoEvento() { return this.tipoEvento; }
	
	public double getTempo() { return this.tempo; }
}
