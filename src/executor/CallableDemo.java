package executor;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for(Future<String> futureResult : results) {
            try {
                System.out.println(futureResult.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
            } catch (ExecutionException e) {
                e.printStackTrace();
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
