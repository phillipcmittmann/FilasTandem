
public class Gerador {
	private int a;
	private int m;
	private int c;
	private int sementeInicial;
	private int sementeAtual;
	
	public Gerador(int a, int m, int c, int sementeInicial) {
		this.a = a;
		this.m = m;
		this.c = c;
		this.sementeInicial = sementeInicial;
		this.sementeAtual = -1;
	}
	
	public double next() {
		this.sementeAtual = (((this.a * this.sementeInicial) + this.c) % this.m);
		return (double)this.sementeAtual / (double)this.m;
	}
}
