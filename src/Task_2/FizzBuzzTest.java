package Task_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzTest {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(() -> fizzBuzz.fizz());
        executorService.execute(() -> fizzBuzz.buzz());
        executorService.execute(() -> fizzBuzz.fizzBuzz());
        executorService.execute(() -> fizzBuzz.notFizzBuzz());

        executorService.shutdown();
    }
}
