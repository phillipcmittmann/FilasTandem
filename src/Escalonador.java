import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Escalonador {
	private Queue eventos;
	
	public Escalonador() {
		this.eventos = new PriorityQueue<Evento>(5, new Comparator<>() {
			@Override
			public int compare(Evento o1, Evento o2) {
				if (o1.getTempo() > o2.getTempo()) return 1;
				else return -1;
			}
		});
	}
	
	public Queue getEventos() { return this.eventos; }
}