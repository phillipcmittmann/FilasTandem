
public class FilaAlvo {
	private double probabilidade;
	private Fila fila;
	
	public FilaAlvo(double probabilidade, Fila fila) {
		super();
		this.probabilidade = probabilidade;
		this.fila = fila;
	}
	
	public double getProbabilidade() {
		return probabilidade;
	}
	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
}
