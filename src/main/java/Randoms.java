import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected PrimitiveIterator.OfInt random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        random = Randoms.randomRange(min, max);
        this.min = min;
        this.max = max;
    }

    public static PrimitiveIterator.OfInt randomRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Минимальное значение не может быть больше максимального");
        }
        return new Random().ints(min, (max + 1)).iterator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt();
            }
        };
    }
}