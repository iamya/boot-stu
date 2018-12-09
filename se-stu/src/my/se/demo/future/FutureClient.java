package my.se.demo.future;

public class FutureClient {


    public Data request(final String request) {

        final FutureData futureData = new FutureData();

        new Thread(() -> {
            RealData realData = new RealData(request);

            futureData.setData(realData);
        }).start();
        return futureData;
    }
}
