package my.se.demo.future;

public class FutureData  implements  Data{

    private RealData data;

    private boolean isReady = false;

    @Override
    public synchronized String getResponse() {
        if(!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return data.getResponse();
    }

    public synchronized void setData(RealData data) {
        if(isReady) {
            return;
        }

        this.data = data;
        isReady = true;
        notify();
    }
}

