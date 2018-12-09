package my.se.demo.future;

public class RealData implements Data {

    public RealData(String request) {
        System.out.println("接收请求,做一些耗时操作");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请求处理完成!");
    }

    @Override
    public String getResponse() {
        return "获得结果";
    }
}
