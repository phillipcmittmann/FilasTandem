import java.util.ArrayList;
import java.util.List;

public class FilaSemCapacidadeMax extends Fila {
	private double[] tempoEmCadaEstado;
	
	@Override
	public void contabilizaTempo(double tempo) {
		this.tempoEmCadaEstado[this.estadoFila] = tempo;
	}
	
	public FilaSemCapacidadeMax(int qtdServidores, double tempoMinChegada, double tempoMaxChegada, double tempoMinSaida, double tempoMaxSaida, String nomeFila) {
		super(qtdServidores, tempoMinChegada, tempoMaxChegada, tempoMinSaida, tempoMaxSaida, nomeFila);
		
		this.tempoEmCadaEstado = new double[1];
	}
	
	@Override
	public void colocaNaFila() {
		this.estadoFila++;
		
		double[] aux = new double[this.tempoEmCadaEstado.length + 1];
		
		for (int i = 0; i < this.tempoEmCadaEstado.length; i++) {
			aux[i] = tempoEmCadaEstado[i];
		}
		
		this.tempoEmCadaEstado = aux;
	}
}
