package my.se.demo.future;

public class Main {

    public static void main(String[] args) {

        String request = "请求参数";

        FutureClient fc = new FutureClient();

        System.out.println("发送请求...");
        Data  data = fc.request(request);

        System.out.println("做其他操作....");

        String response = data.getResponse();

        System.out.println(response);
    }
}
