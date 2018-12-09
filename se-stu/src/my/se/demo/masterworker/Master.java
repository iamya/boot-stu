package my.se.demo.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

    public ConcurrentLinkedQueue<Task> wokerQueue = new ConcurrentLinkedQueue<>();

    public Map<String, Thread> workers = new HashMap<>();

    public ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int workerCount) {
        for (int i = 0; i < workerCount; i++) {
            worker.setWokerQueue(wokerQueue);
            worker.setResultMap(resultMap);
            workers.put("worker_" + i, new Thread(worker));
        }
    }

    public void submit(Task task) {
        wokerQueue.add(task);
    }

    public void execute() {
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }

    public boolean isComplate() {
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            if(entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public int getResult() {

        int sum = 0;
        for(Map.Entry<String, Object> resultEntry : resultMap.entrySet()) {
            sum += (Integer)resultEntry.getValue();
        }
        return sum;
    }
}
