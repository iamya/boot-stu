package my.se.demo;

import my.se.demo.entity.Employee;
import my.se.demo.enums.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {


    @Test
    public void test1() {

        String[] arr = {"aa", "bb", "cc"};
        Arrays.stream(arr).forEach(System.out::println);

        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().forEach(System.out::println);

        Stream.of("aaa", "bbb", "ccc").forEach(System.out::println);

        Stream.iterate('a', (x) -> (char) (x + 2)).limit(10).forEach(System.out::println);

        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);

    }

    // filter distinct limit 过滤/去重/截取
    @Test
    public void test2() {

        Stream.generate(() -> new Random().nextInt(10))
                .limit(12)
                .filter(x -> {
                    System.out.println("开始执行");
                    return x > 3;
                })
                .distinct()
                .limit(2)
                .forEach(System.out::println);
    }

    //映射
    @Test
    public void test3() {

        Stream.of("abc", "def", "ghi", "jkl")
                .map(x -> x.toUpperCase())
                .forEach(System.out::println);

    }

    @Test
    public void test4() {

        List<List<String>> coll = new ArrayList<>();
        coll.add(Arrays.asList("a", "b", "c"));
        coll.add(Arrays.asList("d", "e", "f"));
        coll.stream()
                .flatMap((x) -> x.stream()
                        .map(y -> y.toUpperCase()))
                .forEach(System.out::println);
    }

    @Test
    public void test5() {
        Stream.of("abc", "def", "ghi", "jkl")
                .flatMap(new StreamDemo()::toChar)
                .forEach(System.out::println);
    }



    private  Stream<Character> toChar(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();

    }

    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 5555.00, Status.BUSY),
            new Employee("李四", 20, 4586.23, Status.FREE),
            new Employee("王五", 18, 5866.66, Status.NOTHING),
            new Employee("赵六", 33, 9999.00, Status.BUSY),
            new Employee("刘七", 25, 8888.22, Status.BUSY),
            new Employee("马八", 40, 7788.23, Status.FREE)

    );

    @Test
    public void test6() {
        boolean b = emps.stream()
                .allMatch(e -> e.getSalary() > 5000);
        System.out.println(b);
    }

    @Test
    public void test7() {
        boolean b = emps.stream()
                .anyMatch(e -> e.getSalary() > 5000);
        System.out.println(b);
    }
    @Test
    public void test8() {
        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }

    @Test
    public void test9() {
        Double d = emps.stream()
                .map(Employee::getSalary)
                .reduce(0d, (x, y) -> x + y);
        System.out.println(d);
    }

    @Test
    public void test10() {
        Map<Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

}
