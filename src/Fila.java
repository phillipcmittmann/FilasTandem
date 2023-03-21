
public class Fila {
	private int qtdServidores;
	private int capacidadeMaxFila;
	private int estadoFila;
	private double[] tempoEmCadaEstado;
	private int tempoMinChegada;
	private int tempoMaxChegada;
	private int tempoMinSaida;
	private int tempoMaxSaida;
	private double tempoAnterior;
	
	public Fila(int qtdServidores, int capacidadeMaxFila, int tempoMinChegada, int tempoMaxChegada, int tempoMinSaida, int tempoMaxSaida) {
		this.qtdServidores = qtdServidores;
		this.capacidadeMaxFila = capacidadeMaxFila;
		this.estadoFila = 0;
		this.tempoEmCadaEstado = new double[capacidadeMaxFila + 1];
		this.tempoMinChegada = tempoMinChegada;
		this.tempoMaxChegada = tempoMaxChegada;
		this.tempoMinSaida = tempoMinSaida;
		this.tempoMaxSaida = tempoMaxSaida;
		this.tempoAnterior = 0;
	}
	
	public void colocaNaFila() { this.estadoFila++; }
	public void retiraDaFila() { this.estadoFila--; }
	
	public int getEstadoFila() { return this.estadoFila; }
	
	public int getCapacidadeMaxFila() { return this.capacidadeMaxFila; }
	
	public void setTempoEmCadaEstado(double tempo) { 
		this.tempoEmCadaEstado[this.estadoFila] = tempo - this.tempoAnterior;
		this.tempoAnterior = tempo;
	 }
	
	public int getQtdServidores() { return this.qtdServidores; }
	
	public int getTempoMinChegada() { return this.tempoMinChegada; }
	public int getTempoMaxChegada() { return this.tempoMaxChegada;  }
	public int getTempoMinSaida() { return this.tempoMinSaida; }
	public int getTempoMaxSaida() { return this.tempoMaxSaida; }
	public double[] getTempoEstadosFila() { return this.tempoEmCadaEstado; }
	
	public String toStringTempoEstadosFila() { return this.tempoEmCadaEstado.toString(); }
}
