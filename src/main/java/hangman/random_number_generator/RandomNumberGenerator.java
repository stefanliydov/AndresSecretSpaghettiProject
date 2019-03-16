package hangman.random_number_generator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

    public static int generate(int n) {
        return ThreadLocalRandom.current().nextInt(n);
    }
    public static int generate(int n, int y) {
        return ThreadLocalRandom.current().nextInt(n,y);
    }

}
