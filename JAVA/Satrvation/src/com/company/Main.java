package com.company;

public class Main {
    private static Object lock = new Object();

    public static void main(String[] args) {
	// write your code here
    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i=9; i<100; i++){
                synchronized (lock){
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                }
            }
        }
    }


}
