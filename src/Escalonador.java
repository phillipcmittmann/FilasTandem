import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Escalonador {
	private Queue<Evento> eventos;
	private Gerador gerador;
	
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
	
	public void agendaEvento(Fila fila, int contadorInteracoes, TipoEvento tipoEvento) {
		double random = gerador.next();
		contadorInteracoes++;

		if (tipoEvento == TipoEvento.CHEGADA) {
			double tempoEvento = ((fila.getTempoMaxChegada() - fila.getTempoMinChegada()) * random) + fila.getTempoMinChegada();	
			
			eventos.add(new Evento(tipoEvento, tempoEvento));
		} else if (tipoEvento == TipoEvento.SAIDA) {
			double tempoEvento = ((fila.getTempoMaxSaida() - fila.getTempoMinSaida()) * random) + fila.getTempoMinSaida();	
			
			eventos.add(new Evento(tipoEvento, tempoEvento));
		}
	}
	
	public Queue<Evento> getEventos() { return this.eventos; }
}