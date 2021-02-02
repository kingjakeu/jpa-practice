package com.kingjakeu.springstudy;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future1 = executorService.submit(() -> {
            Thread.sleep(10000);
            System.out.println("hi");
            return "1";
        });
        System.out.println("hello");
        Future<String> future2 = executorService.submit(() -> {
            Thread.sleep(5000);
            System.out.println("world");
            return "2";
        });
        String str1 = future1.get();
        System.out.println(str1);
    }
}
