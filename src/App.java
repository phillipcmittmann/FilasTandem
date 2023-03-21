import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int qtdServidores = 1;
		int capacidadeMaxFila = 5;
		int maxInteracoes = 100000;
		double tempo = 0;
		int qtdPerdas = 0;
		
		int a = 51861;
		int m = 31813;
		int c = 13584;
		int sementeInicial = 15833;
		
		Escalonador escalonador = new Escalonador(a, m, c, sementeInicial);
		
		Fila fila = new Fila(qtdServidores, capacidadeMaxFila, 2, 4, 3, 5);
		
		escalonador.getEventos().add(new Evento(TipoEvento.CHEGADA, 3));
		
		while (escalonador.getContadorInteracoes() < maxInteracoes) {
			Evento eventoAtual = escalonador.getEventos().poll();
			tempo = tempo + eventoAtual.getTempo();
			fila.setTempoEmCadaEstado(tempo);
			
			if (eventoAtual.getTipoEvento() == TipoEvento.SAIDA) {
				fila.retiraDaFila();
			} else if (eventoAtual.getTipoEvento() == TipoEvento.CHEGADA) {
				if (fila.getEstadoFila() < fila.getCapacidadeMaxFila()) {
					fila.colocaNaFila();
					
					if (fila.getEstadoFila() <= fila.getQtdServidores()) {
						escalonador.agendaEvento(fila, TipoEvento.SAIDA, tempo);
					}
					
					escalonador.agendaEvento(fila, TipoEvento.CHEGADA, tempo);
				} else {
					qtdPerdas++;
					escalonador.agendaEvento(fila, TipoEvento.CHEGADA, tempo);
				}
			}
		}
		
		System.out.println(Arrays.toString(fila.getTempoEstadosFila()));
		System.out.println("Perdas: " + qtdPerdas);
	}
}
