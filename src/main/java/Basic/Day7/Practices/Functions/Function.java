package Basic.Day7.Practices.Functions;

public class Function {
    @FunctionalInterface
    public interface IntFunction<R> {
        R apply(int value);
    }
    @FunctionalInterface
    public interface LongFunction<R> {
        R apply(long value);
    }
    @FunctionalInterface
    public interface DoubleFunction<R>
    {
        R apply(double value);
    }
    public static void main (String[] args) {
        IntFunction<String> ifunc
                = x -> Integer.toString(x * x);
        LongFunction<String> lfunc
                = x -> Long.toString(x * x);
        DoubleFunction<String> dfunc
                = x -> Double.toString(x * x);
        System.out.println(ifunc.apply(3));
        System.out.println(lfunc.apply(5));
        System.out.println(dfunc.apply(10.9));
    }
}
