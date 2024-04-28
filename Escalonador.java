import java.util.PriorityQueue;

public class Escalonador {
    private PriorityQueue<Evento> fila;
    private MyComparator comparator;

    public Escalonador() {
        this.comparator = new MyComparator();

        fila = new PriorityQueue<>(this.comparator);
    }

    public PriorityQueue<Evento> getFila() {
        return this.fila;
    }

    public void agendaChegada(double tempo) {
        Evento novoEvento = new Evento(0, tempo);
        fila.add(novoEvento);
    }

    public void agendaChegada(Evento evento) {
        fila.add(evento);
    }

    public void agendaSaida(double tempo) {
        Evento novoEvento = new Evento(1, tempo);
        fila.add(novoEvento);
    }
    
    public void agendaPassagem(double tempo) {
    	Evento novoEvento = new Evento(2, tempo);
    	fila.add(novoEvento);
    }
    
    public void agendaVolta(double tempo) {
    	Evento novoEvento = new Evento(3, tempo);
    	fila.add(novoEvento);
    }
}