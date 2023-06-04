import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		int maxInteracoes = 100000;
		int a = 51861;
		int m = 31813;
		int c = 13584;
		int sementeInicial = 15833;
		double tempo = 0;
		int qtdPerdas = 0;
		
		Escalonador escalonador = new Escalonador(a, m, c, sementeInicial);
	
		FilaSemCapacidadeMax fila1 = new FilaSemCapacidadeMax(1, 1, 4, 1, 2, "fila1");
		Fila fila2 = new Fila(3, 5, 5, 10, "fila2");
		Fila fila3 = new Fila(2, 8, 10, 20, "fila3");

		List<FilaAlvo> aux = new ArrayList<FilaAlvo>();
		List<FilaAlvo> aux2 = new ArrayList<FilaAlvo>();
		List<FilaAlvo> aux3 = new ArrayList<FilaAlvo>();
		
		aux.add(new FilaAlvo(0.8, fila2));
		aux.add(new FilaAlvo(0.2, fila3));
		fila1.setFilasAlvo(aux);
		
		aux2.add(new FilaAlvo(0.3, fila1));
		aux2.add(new FilaAlvo(0.2, null));
		aux2.add(new FilaAlvo(0.5, fila3));
		fila2.setFilasAlvo(aux2);
		
		aux3.add(new FilaAlvo(0.7, fila2));
		aux3.add(new FilaAlvo(0.3, null));
		fila3.setFilasAlvo(aux3);
		
		escalonador.getEventos().add(new Evento(TipoEvento.CHEGADA, 1.0, fila1));
		
		while (escalonador.getContadorInteracoes() < maxInteracoes) {
			Evento eventoAtual = escalonador.getEventos().poll();
			tempo = eventoAtual.getTempo();
			
			if (eventoAtual.getTipoEvento() == TipoEvento.CHEGADA) {
				fila1.contabilizaTempo(tempo);
				fila2.contabilizaTempo(tempo);
				fila3.contabilizaTempo(tempo);
				
				if (eventoAtual.getFila().getEstadoFila() <= eventoAtual.getFila().getQtdServidores()) {
					escalonador.agendaEvento(eventoAtual.getFila(), TipoEvento.TROCA, tempo);
					
					if (eventoAtual.getFila().getCapacidadeMaxFila() != 0) {
						if (eventoAtual.getFila().getEstadoFila() < eventoAtual.getFila().getCapacidadeMaxFila()) {
							eventoAtual.getFila().colocaNaFila();
						} else {
							qtdPerdas++;
						}
					} else {
						eventoAtual.getFila().colocaNaFila();
					}
				}
				
				escalonador.agendaEvento(fila1, TipoEvento.CHEGADA, tempo);
			} else if (eventoAtual.getTipoEvento() == TipoEvento.SAIDA) {
				fila1.contabilizaTempo(tempo);
				fila2.contabilizaTempo(tempo);
				fila3.contabilizaTempo(tempo);
				eventoAtual.getFila().retiraDaFila();
				
				if (eventoAtual.getFila().getEstadoFila() >= eventoAtual.getFila().getQtdServidores()) {
					escalonador.agendaEvento(eventoAtual.getFila(), TipoEvento.SAIDA, tempo);
				}
			} else if (eventoAtual.getTipoEvento() == TipoEvento.TROCA) {
				fila1.contabilizaTempo(tempo);
				fila2.contabilizaTempo(tempo);
				fila3.contabilizaTempo(tempo);
				eventoAtual.getFila().retiraDaFila();
				
				Fila filaAlvo = eventoAtual.getFila().getFilaAlvo(escalonador.geraAleatorio());
				
				if (eventoAtual.getFila().getEstadoFila() >= eventoAtual.getFila().getCapacidadeMaxFila()) {
					escalonador.agendaEvento(eventoAtual.getFila(), TipoEvento.TROCA, tempo);
				}
				
				if (filaAlvo.getCapacidadeMaxFila() == 0) {
					filaAlvo.colocaNaFila();
				} else if (filaAlvo.getEstadoFila() < filaAlvo.getCapacidadeMaxFila()) {
					filaAlvo.colocaNaFila();
					
					if (filaAlvo.getEstadoFila() <= filaAlvo.getQtdServidores()) {
						escalonador.agendaEvento(filaAlvo, TipoEvento.SAIDA, tempo);
					}
				} else {
					qtdPerdas++;
				}
			}
		}
		
		System.out.println(Arrays.toString(fila1.getTempoEstadosFila()));
		System.out.println(Arrays.toString(fila2.getTempoEstadosFila()));
		System.out.println(Arrays.toString(fila3.getTempoEstadosFila()));
		System.out.println("Perdas: " + qtdPerdas);
	}
}
