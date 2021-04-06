package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
	// write your code here

        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE, bufferLock);

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
