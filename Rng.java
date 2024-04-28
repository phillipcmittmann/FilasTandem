public class Rng {
    private int a;
    private int c;
    private int M;
    private int x;

    public Rng(int a, int c, int M, int x0) {
        this.a = a;
        this.c = c;
        this.M = M;
        this.x = x0;
    }

    public double next() {
        x = (a * x + c) % M;
        return (double) x / M;
    }
}