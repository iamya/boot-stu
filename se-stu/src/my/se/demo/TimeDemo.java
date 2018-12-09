package my.se.demo;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TimeDemo {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Test //抛异常
    public void test1() throws ExecutionException, InterruptedException {

        Callable<Date> task = new Callable() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20120102");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<Date> submit = pool.submit(task);
            list.add(submit);
        }

        for (Future<Date> future : list) {
            System.out.println(future.get());
        }

    }

    @Test  //加锁
    public void test2() throws ExecutionException, InterruptedException {
        Callable<Date> task = new Callable() {
            @Override
            public Date call() throws Exception {
                return TimeDemo.convert("20120102");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<Date> submit = pool.submit(task);
            list.add(submit);
        }

        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {

        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.of(2012,01,02);
            }
        };




        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<LocalDate> submit = pool.submit(task);
            list.add(submit);
        }

        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }
    }

    private static final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };


    public static Date convert(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }
}
