
public class Fila {
	private int qtdServidores;
	private int capacidadeMaxFila;
	private int estadoFila;
	private double[] tempoEmCadaEstado;
	
	public Fila(int qtdServidores, int capacidadeMaxFila) {
		this.qtdServidores = qtdServidores;
		this.capacidadeMaxFila = capacidadeMaxFila;
		this.estadoFila = 0;
		this.tempoEmCadaEstado = new double[capacidadeMaxFila];
	}
	
	public int getEstadoFila() { return this.estadoFila; }
	public void colocaNaFila() { this.estadoFila++; }
	
	public int getCapacidadeMaxFila() { return this.capacidadeMaxFila; }
	
	public void setTempoEmCadaEstado(double tempo) { this.tempoEmCadaEstado[this.estadoFila] = tempo; }
}
