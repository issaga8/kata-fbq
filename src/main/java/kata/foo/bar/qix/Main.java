package kata.foo.bar.qix;

/**
 * Main class
 */

public class Main {
    public static void main(String[] args) {
        String numbers [] = {"1","753", "200000"};
        FooBarQixImpl f = new FooBarQixImpl();
        f.CalculateFooBarQix(numbers);
        numbers = null;
        f.CalculateFooBarQix(numbers);

    }

}

