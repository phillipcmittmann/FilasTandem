public class Evento implements Comparable<Evento> {
    private int tipo; // 0 = CHEGADA, 1 = SAIDA, 2 = PASSAGEM
    private double tempo;

    public Evento(int tipo, double tempo) {
        this.tipo = tipo;
        this.tempo = tempo;
    }

    public int getTipo() {
        return this.tipo;
    }

    public double getTempo() {
        return this.tempo;
    }
    
    @Override
    public int compareTo(Evento ev) {
        if (this.tempo == ev.getTempo()) {
            return 0;
        } else if (this.tempo > ev.getTempo()) {
            return 1;
        } else {
            return -1;
        }
    }
}