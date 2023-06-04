import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Escalonador {
	private Queue<Evento> eventos;
	private Gerador gerador;
	private int contadorInteracoes = 0;
	
	public Escalonador(int a, int m, int c, int sementeInicial) {
		this.eventos = new PriorityQueue<Evento>(5, new Comparator<>() {
			@Override
			public int compare(Evento o1, Evento o2) {
				if (o1.getTempo() > o2.getTempo()) return 1;
				else return -1;
			}
		});
		
		this.gerador = new Gerador(a, m, c, sementeInicial);
	}
	
	public void agendaEvento(Fila fila, TipoEvento tipoEvento, double tempoAtual) {
		if (tipoEvento == TipoEvento.CHEGADA) {
			double tempoEvento = ((fila.getTempoMaxChegada() - fila.getTempoMinChegada()) * geraAleatorio()) + fila.getTempoMinChegada();

			eventos.add(new Evento(tipoEvento, tempoEvento + tempoAtual, fila));
		} else if (tipoEvento == TipoEvento.SAIDA) {
			double tempoEvento = ((fila.getTempoMaxSaida() - fila.getTempoMinSaida()) * geraAleatorio()) + fila.getTempoMinSaida();

			eventos.add(new Evento(tipoEvento, tempoEvento + tempoAtual, fila));
		} else if (tipoEvento == TipoEvento.TROCA) {
			double tempoEvento = ((fila.getTempoMaxSaida() - fila.getTempoMinSaida()) * geraAleatorio()) + fila.getTempoMinSaida();
			
			eventos.add(new Evento(tipoEvento, tempoEvento + tempoAtual, fila));
		}
	}
	
	public double geraAleatorio() {
		double random = gerador.next();
		this.contadorInteracoes++;
		
		return random;
	}

	public Queue<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Queue<Evento> eventos) {
		this.eventos = eventos;
	}

	public Gerador getGerador() {
		return gerador;
	}

	public void setGerador(Gerador gerador) {
		this.gerador = gerador;
	}

	public int getContadorInteracoes() {
		return contadorInteracoes;
	}

	public void setContadorInteracoes(int contadorInteracoes) {
		this.contadorInteracoes = contadorInteracoes;
	}

}
