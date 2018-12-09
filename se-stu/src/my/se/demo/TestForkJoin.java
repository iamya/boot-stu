package my.se.demo;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    @Test  //使用ForkJoin居然时间还长.
    public void test() {

        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinCacluate(0, 100000000000L);

        Long sum = pool.invoke(task);

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());  //52395

    }

    @Test
    public void test1() {
        Instant start = Instant.now();

        long sum = 0;
        for(long i = 0; i < 100000000000L; i ++) {
            sum += i;
        }

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());  //42537
    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .sum();

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).toMillis());  //36515

    }
}
