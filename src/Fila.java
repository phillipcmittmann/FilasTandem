
public class Fila {
	private int qtdServidores;
	private int capacidadeMaxFila;
	private int estadoFila;
	private double[] tempoEmCadaEstado;
	int tempoMinChegada;
	int tempoMaxChegada;
	int tempoMinSaida;
	int tempoMaxSaida;
	
	public Fila(int qtdServidores, int capacidadeMaxFila, int tempoMinChegada, int tempoMaxChegada, int tempoMinSaida, int tempoMaxSaida) {
		this.qtdServidores = qtdServidores;
		this.capacidadeMaxFila = capacidadeMaxFila;
		this.estadoFila = 0;
		this.tempoEmCadaEstado = new double[capacidadeMaxFila];
		this.tempoMinChegada = tempoMinChegada;
		this.tempoMaxChegada = tempoMaxChegada;
		this.tempoMinSaida = tempoMinSaida;
		this.tempoMaxSaida = tempoMaxSaida;
	}
	
	public void colocaNaFila() { this.estadoFila++; }
	public void retiraDaFila() { this.estadoFila--; }
	
	public int getEstadoFila() { return this.estadoFila; }
	
	public int getCapacidadeMaxFila() { return this.capacidadeMaxFila; }
	
	public void setTempoEmCadaEstado(double tempo) { this.tempoEmCadaEstado[this.estadoFila] = tempo; }
	
	public int getQtdServidores() { return this.qtdServidores; }
	
	public int getTempoMinChegada() { return this.tempoMinChegada; }
	public int getTempoMaxChegada() { return this.tempoMaxChegada;  }
	public int getTempoMinSaida() { return this.tempoMinSaida; }
	public int getTempoMaxSaida() { return this.tempoMaxSaida; }
	
	public String toStringTempoEstadosFila() { return this.tempoEmCadaEstado.toString(); }
}
