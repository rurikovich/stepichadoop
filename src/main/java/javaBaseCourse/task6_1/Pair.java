package javaBaseCourse.task6_1;

/**
 * Created by User on 09.01.2017.
 */
public class Pair<F , S> {
    private F first;
    private S second;

    public Pair(F f, S s) {
        first = f;
        second = s;
    }


    public static <F , S> Pair<F, S> of(F f, S s) {
        return new Pair<>(f, s);
    }


    public F getFirst() {
        return first;
    }


    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return second != null ? second.equals(pair.second) : pair.second == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
