
public class Main {
    public static void main(String[] args) {
    	int nAleatorios = 1000;
        double tempoGlobal = 0.0;

        Rng r = new Rng(12, 23, 4534535, 65);
        
        //G/G/2/3, chegadas entre 1..4, atendimento entre 3..4
        //G/G/1/5, atendimento entre 2..3
        
        Fila f1 = new Fila(2, 3, 1, 4, 3, 4);
        Fila f2 = new Fila(1, 5, 2, 3);
        
        Escalonador esc = new Escalonador();

        Evento ev = new Evento(0, 3);

        esc.agendaChegada(ev);
        
        while (true) {
            if (nAleatorios == 0) {
                break;
            } else {
                Evento proxEvento = esc.getFila().poll();
 
                if (proxEvento.getTipo() == 0) {
                    tempoGlobal = proxEvento.getTempo();
                    f1.setEstado(f1.getEstadoAtualFila(), f1.getEstados()[f1.getEstadoAtualFila()] + tempoGlobal);
                	f2.setEstado(f2.getEstadoAtualFila(), f2.getEstados()[f2.getEstadoAtualFila()] + tempoGlobal);

                    if (f1.getEstadoAtualFila() < f1.getCapacidade()) {
                    	f1.chegadaCliente();
                    	
                    	if (f1.getEstadoAtualFila() <= f1.getServidores()) {
                    		esc.agendaPassagem(tempoGlobal + r.next());
                    		nAleatorios--;
                    	}
                    } else {
                    	f1.addPerda();
                    }
                    
                    esc.agendaChegada(tempoGlobal + r.next());
                    nAleatorios--;
                    
                } else if (proxEvento.getTipo() == 1) {
                	tempoGlobal = proxEvento.getTempo();
                	
                	f1.setEstado(f1.getEstadoAtualFila(), f1.getEstados()[f1.getEstadoAtualFila()] + tempoGlobal);
                	f2.setEstado(f2.getEstadoAtualFila(), f2.getEstados()[f2.getEstadoAtualFila()] + tempoGlobal);
                	
                	f2.saidaCliente();
                	
                	if (f2.getEstadoAtualFila() >= f1.getServidores()) {
                    	esc.agendaSaida(tempoGlobal + r.next());
                    	nAleatorios--;
                    }
                } else if (proxEvento.getTipo() == 2) {
                	tempoGlobal = proxEvento.getTempo();
                	
                	f1.setEstado(f1.getEstadoAtualFila(), f1.getEstados()[f1.getEstadoAtualFila()] + tempoGlobal);
                	f2.setEstado(f2.getEstadoAtualFila(), f2.getEstados()[f2.getEstadoAtualFila()] + tempoGlobal);
                	
                	f1.saidaCliente();
                	
                	if (f1.getEstadoAtualFila() >= f1.getServidores()) {
                		esc.agendaPassagem(tempoGlobal);
                	}
                	
                	if (f2.getEstadoAtualFila() < f2.getCapacidade()) {
                		f2.chegadaCliente();
                		
                		if (f2.getEstadoAtualFila() <= f2.getServidores()) {
                			esc.agendaSaida(tempoGlobal);
                		}
                	} else {
                		f2.addPerda();
                	}
                }
            }
        }
        
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
