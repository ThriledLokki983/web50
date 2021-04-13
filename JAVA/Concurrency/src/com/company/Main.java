package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	// write your code here

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        /*ReentrantLock bufferLock = new ReentrantLock();*/

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);

        /*new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();*/

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "This is being printed from the Callable Class ");
                return "This is the Callable Result";
            }
        });

        try {
            System.out.println(ThreadColor.ANSI_GREEN + future.get());
        }catch (ExecutionException e){
            System.out.println(ThreadColor.ANSI_RED + "Something went wrong");
        }catch (InterruptedException e){
            System.out.println(ThreadColor.ANSI_RED + "Thread running the task was interrupted");
        }

        executorService.shutdown();
    }

}
