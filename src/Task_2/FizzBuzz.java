package Task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz extends Thread {

    private Consumer<Integer> consumer;

    private AtomicBoolean isNumberProcessed = new AtomicBoolean(false);

    private Integer number;

    public FizzBuzz(Consumer<Integer> consumer) {
        this.consumer = consumer;
    }

    public void setNumber(int number) {
        this.number = number;
        isNumberProcessed.set(false);
    }

    @Override
    public void run() {
        while (true) {
            if (!isNumberProcessed.get()) {
                consumer.accept(number);
                isNumberProcessed.set(true);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        int counter;

        FizzBuzz fizz = new FizzBuzz((counter) -> {
            if (counter % 3 == 0)
                System.out.println("fizz");
        });

        FizzBuzz buzz = new FizzBuzz((counter) -> {
            if (counter % 5 == 0)
                System.out.println("buzz");
        });

        FizzBuzz fizzBuzz = new FizzBuzz((counter) -> {
            if (counter % 3 == 0 && counter % 5 == 0)
                System.out.println("fizzbuzz");
        });

        FizzBuzz notFizzBuzz = new FizzBuzz((counter) -> {
            if (counter % 3 != 0 && counter % 5 != 0)
                System.out.println(counter);
        });


        for(int i = 0; i<15; i++){
            counter = i;
            executorService.execute(fizz);
            executorService.execute(buzz);
            executorService.execute(fizzBuzz);
            executorService.execute(notFizzBuzz);
        }
    }
}
