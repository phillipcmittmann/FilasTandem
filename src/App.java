
public class App {

	public static void main(String[] args) {
		int qtdServidores = 2;
		int capacidadeMaxFila = 6;
		int maxInteracoes = 5;
		double tempo = 0;
		int qtdPerdas = 0;
		
		int a = 4;
		int m = 9;
		int c = 4;
		int sementeInicial = 7;
		
		Escalonador escalonador = new Escalonador(a, m, c, sementeInicial);
		
		Fila fila = new Fila(qtdServidores, capacidadeMaxFila, 2, 4, 3, 5);
		
		escalonador.agendaEvento(fila, TipoEvento.CHEGADA, 0);
		
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
				}
			}
		}
		
		System.out.println(fila.toStringTempoEstadosFila());
	}
}
