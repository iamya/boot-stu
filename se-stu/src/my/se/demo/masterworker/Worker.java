package my.se.demo.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

    public ConcurrentLinkedQueue<Task> wokerQueue;

    public ConcurrentHashMap<String, Object> resultMap;

    public void setWokerQueue(ConcurrentLinkedQueue<Task> wokerQueue) {
        this.wokerQueue = wokerQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        Task task = null;
        while (true) {
            task = this.wokerQueue.poll();
            if (task == null) break;
            Object result = task.handle();
            this.resultMap.put(task.getName(), result);
        }
    }
}
