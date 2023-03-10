
public class Fila {
	private int qtdServidores;
	private int capacidadeMaxFila;
	private int estadoFila;
	
	public Fila(int qtdServidores, int capacidadeMaxFila) {
		this.qtdServidores = qtdServidores;
		this.capacidadeMaxFila = capacidadeMaxFila;
		this.estadoFila = 0;
	}
	
	public int getEstadoFila() { return this.estadoFila; }
	public void colocaNaFila() { this.estadoFila++; }
	
	public int getCapacidadeMaxFila() { return this.capacidadeMaxFila; }
}
