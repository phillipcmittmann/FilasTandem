public class Fila {
    private int minChegada;
    private int maxChegada;
    private int minAtendimento;
    private int maxAtendimento;
    private int estadoAtualFila;
    private int servidores;
    private int capacidade;
    private int perda;
    private double[] estados;

    public Fila(int servidores, int capacidade, int minChegada, int maxChegada, int minAtendimento, int maxAtendimento) {
        this.estadoAtualFila = 0;
        this.estados = new double[capacidade + 1];
        this.servidores = servidores;
        this.capacidade = capacidade;
        this.minChegada = minChegada;
        this.maxChegada = maxChegada;
        this.minAtendimento = minAtendimento;
        this.maxAtendimento = maxAtendimento;
        this.perda = 0;
    }
    
    public Fila(int servidores, int capacidade, int minAtendimento, int maxAtendimento) {
    	this.estadoAtualFila = 0;
    	this.estados = new double[capacidade + 1];
        this.servidores = servidores;
        this.capacidade = capacidade;
        this.minAtendimento = minAtendimento;
        this.maxAtendimento = maxAtendimento;
        this.perda = 0;
    }

    public int getMinChegada() {
        return this.minChegada;
    }

    public int getMaxChegada() {
        return this.maxChegada;
    }

    public int getMinAtendimento() {
        return this.minAtendimento;
    }

    public int getMaxAtendimento() {
        return this.maxAtendimento;
    }

    public int getServidores() {
        return this.servidores;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public int getPerda() {
        return this.perda;
    }

    public void addPerda() {
        this.perda++;
    }

    public int getEstadoAtualFila() {
        return this.estadoAtualFila;
    }

    public void setEstadoAtualFila(int novEstadoAtualFila) {
        this.estadoAtualFila = novEstadoAtualFila;
    }

    public double[] getEstados() {
        return this.estados;
    }

    public void setEstado(int posicao, double valor) {
        this.estados[posicao] = valor;
    }

    public void chegadaCliente() {
        this.estadoAtualFila++;
    }

    public void saidaCliente() {
        this.estadoAtualFila--;
    }

    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append("G|G|").append(this.servidores).append("|").append(this.capacidade).append(" --> CH: ").append(this.minChegada).append("..").append(this.maxChegada).append(" --> AT: ").append(this.minAtendimento).append("..").append(this.maxAtendimento).append("\n");

        for (int i = 0; i < estados.length; i++) {
            msg.append("est").append(i).append(": ").append(estados[i]).append("\n");
        }
        
        msg.append("perdas: ").append(perda).append("\n");

        return msg.toString();
    }
}