package my.se.demo;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println(Single1.getInstance() == Single1.getInstance());
        System.out.println(Single2.getInstance() == Single2.getInstance());
        System.out.println(Single3.getInstance() == Single3.getInstance());
        System.out.println(Single4.INSTANCE == Single4.INSTANCE);
    }
}

/**
 * 饿汉式
 */
class Single1 {

    private static Single1 instance = new Single1();

    private Single1(){}

    public static Single1 getInstance() {

        return instance;
    }

}

/**
 * 懒汉式,double check
 */
class Single2 {

    private volatile  static Single2 instance;  //JVM重排 由:分配空间->实例对象->指向对象 变为: 分配空间->指向空间->实例对象

    private Single2() {}

    public static Single2 getInstance() {
        synchronized (Single2.class) {
            if(instance == null) {
                synchronized (Single2.class) {
                    if (instance == null) {
                        instance =  new Single2();
                    }
                }
            }
        return instance;
        }
    }
}

/**
 * static inner class
 */
class Single3 {

    private  Single3(){}

    private static class Single {
        private static final Single instance = new Single();
    }

    public static Single getInstance() {
        return Single.instance;
    }
}

/**
 * 枚举单例,防止反射.
 */
enum Single4 {
    INSTANCE;
}