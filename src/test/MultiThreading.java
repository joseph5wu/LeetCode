package test;

import java.util.concurrent.*;

public class MultiThreading {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newScheduledThreadPool(5);
        Task task1 = new Task(1);
//        Task task2 = new Task(2);
        FutureTask<Integer> fTask1 = new FutureTask<Integer>(task1);
        executor.submit(fTask1);

        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main task is working");

        try {
            System.out.println("task execution result: " + fTask1.get());
        }
        catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("all tasks have been executed");
        executor.shutdown();
    }
}

class Task implements Callable<Integer> {
    int id = 0;
    public Task(int id) {
        this.id = id;
    }

    public Integer call() throws Exception {
        System.out.println("sub task-" + id + " is working");
        Thread.sleep(3000);
        int sum = 0;
        for(int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
