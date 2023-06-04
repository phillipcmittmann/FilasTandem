import java.util.ArrayList;
import java.util.List;

public class Fila {
	private int qtdServidores;
	private int capacidadeMaxFila;
	protected int estadoFila;
	protected double[] tempoEmCadaEstado;
	private double tempoMinChegada;
	private double tempoMaxChegada;
	private double tempoMinSaida;
	private double tempoMaxSaida;
	private List<FilaAlvo> filasAlvo;
	private String nomeFila;
	
	// SEM CAPACIDADE MAXIMA
	public Fila(int qtdServidores, double tempoMinChegada, double tempoMaxChegada, double tempoMinSaida, double tempoMaxSaida, String nomeFila) {
		this.qtdServidores = qtdServidores;
		this.estadoFila = 0;
		this.tempoMinChegada = tempoMinChegada;
		this.tempoMaxChegada = tempoMaxChegada;
		this.tempoMinSaida = tempoMinSaida;
		this.tempoMaxSaida = tempoMaxSaida;
		this.nomeFila = nomeFila;
	}
	
	// SEM TEMPO DE CHEGADA
	public Fila(int qtdServidores, int capacidadeMaxFila, double tempoMinSaida, double tempoMaxSaida, String nomeFila) {
		this.qtdServidores = qtdServidores;
		this.capacidadeMaxFila = capacidadeMaxFila;
		this.estadoFila = 0;
		this.tempoEmCadaEstado = new double[capacidadeMaxFila + 1];
		this.tempoMinSaida = tempoMinSaida;
		this.tempoMaxSaida = tempoMaxSaida;
		this.nomeFila = nomeFila;
	}
	
	public Fila() {}
	
	public void colocaNaFila() { this.estadoFila++; }
	public void retiraDaFila() { this.estadoFila--; }
	
	public double[] getTempoEmCadaEstado() {
		return tempoEmCadaEstado;
	}

	public void setTempoEmCadaEstado(double[] tempoEmCadaEstado) {
		this.tempoEmCadaEstado = tempoEmCadaEstado;
	}

	public String getNomeFila() {
		return nomeFila;
	}

	public void setNomeFila(String nomeFila) {
		this.nomeFila = nomeFila;
	}

	public void setQtdServidores(int qtdServidores) {
		this.qtdServidores = qtdServidores;
	}

	public void setCapacidadeMaxFila(int capacidadeMaxFila) {
		this.capacidadeMaxFila = capacidadeMaxFila;
	}

	public void setEstadoFila(int estadoFila) {
		this.estadoFila = estadoFila;
	}

	public void setTempoMinChegada(double tempoMinChegada) {
		this.tempoMinChegada = tempoMinChegada;
	}

	public void setTempoMaxChegada(double tempoMaxChegada) {
		this.tempoMaxChegada = tempoMaxChegada;
	}

	public void setTempoMinSaida(double tempoMinSaida) {
		this.tempoMinSaida = tempoMinSaida;
	}

	public void setTempoMaxSaida(double tempoMaxSaida) {
		this.tempoMaxSaida = tempoMaxSaida;
	}

	public int getEstadoFila() { return this.estadoFila; }
	
	public int getCapacidadeMaxFila() { return this.capacidadeMaxFila; }
	
	public void contabilizaTempo(double tempo) {
		this.tempoEmCadaEstado[this.estadoFila] = tempo;
	}
	
	public int getQtdServidores() { return this.qtdServidores; }
	
	public double getTempoMinChegada() { return this.tempoMinChegada; }
	public double getTempoMaxChegada() { return this.tempoMaxChegada;  }
	public double getTempoMinSaida() { return this.tempoMinSaida; }
	public double getTempoMaxSaida() { return this.tempoMaxSaida; }
	public double[] getTempoEstadosFila() { return this.tempoEmCadaEstado; }

	public List<FilaAlvo> getFilasAlvo() {
		return filasAlvo;
	}
	
	public void setFilasAlvo(List<FilaAlvo> filasAlvo) {
		this.filasAlvo = filasAlvo;
	}
	
	public Fila getFilaAlvo(double random) {
		FilaAlvo aux = this.getFilasAlvo().get(0);
		
		for (FilaAlvo fila : this.getFilasAlvo()) {
			if (random >= fila.getProbabilidade() && random >= aux.getProbabilidade()) {
				aux = fila;
			}
		}
		
		return aux.getFila();
	}
	
	public String toStringTempoEstadosFila() { return this.tempoEmCadaEstado.toString(); }
}
