package Task_1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class RunTimer {

    public static long calculateRunningTime(AtomicLong startTime){
        AtomicLong currentTime = new AtomicLong();
        currentTime.set(System.currentTimeMillis());
        return (currentTime.get() - startTime.get()) / 100;
    }

    public static void startTimer(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        AtomicLong startTime = new AtomicLong(System.currentTimeMillis());

        scheduledExecutorService.scheduleAtFixedRate(
                () -> {
                    System.out.println(calculateRunningTime(startTime) + " ms");
                },
                0,
                1,
                TimeUnit.SECONDS
        );

        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("5 seconds have passed"),
                5,
                5,
                TimeUnit.SECONDS
        );
    }
}
