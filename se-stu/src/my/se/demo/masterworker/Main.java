package my.se.demo.masterworker;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Master master = new Master(new Worker(), 20);

        Random random = new Random();
        for( int i = 0; i < 100; i ++) {
            Task task = new Task();
            task.setId(i);
            task.setName("task_" + i);
            task.setPrice(random.nextInt(1000));
            master.submit(task);
        }

        master.execute();

        Instant start = Instant.now();
        int result = 0;
        while(true) {
            if(master.isComplate()) {
                result = master.getResult();
                break;
            }
        }
        System.out.println(result);
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());

    }
}
