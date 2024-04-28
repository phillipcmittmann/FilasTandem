import java.util.Comparator;

public class MyComparator implements Comparator<Evento> {

    @Override
    public int compare(Evento o1, Evento o2) {
        return Double.compare(o1.getTempo(), o2.getTempo());
    }
}