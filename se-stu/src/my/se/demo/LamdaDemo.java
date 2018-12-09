package my.se.demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LamdaDemo {

    public static void main(String[] args) {

        new LamdaDemo().getVaule("abc", x -> System.out.println(x.toUpperCase()));
        System.out.println(new LamdaDemo().getValue2(() -> "abc".toUpperCase()));
        System.out.println(new LamdaDemo().getValule3("abc", x -> x.toUpperCase()));
    }

    //字符操作
    public void  getVaule(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    public String getValue2(Supplier<String> supplier) {
        return supplier.get();
    }

    public String getValule3(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
}
