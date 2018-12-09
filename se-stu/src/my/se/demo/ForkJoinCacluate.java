package my.se.demo;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCacluate extends RecursiveTask<Long> {

    private  long start;

    private long end;

    private  static final long JOBSIZE = 1000000L;


    public ForkJoinCacluate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if(end - start < JOBSIZE) {

            long sum = 0L;

            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        } else {

            long mid = (start + end) >> 1;

            ForkJoinCacluate left = new ForkJoinCacluate(start, mid);
            left.fork();

            ForkJoinCacluate right = new ForkJoinCacluate(mid + 1, end);
            right.fork();

            return left.join() + right.join();
        }

    }



}
