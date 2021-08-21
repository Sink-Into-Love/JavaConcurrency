package com.it.concurrency.javaconcurrency.createThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "FutureTask")
public class create3 {

    public static void main(String[] args) {

        try {
            Integer i1 = (Integer) create1();
            Integer i2 = (Integer) create2();
            log.debug("{},{}", i1, i2);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("create3");
    }

    public static Object create1() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("t1_running");
                Thread.sleep(1000);
                return 1000;
            }
        });

        Thread t = new Thread(futureTask, "t1");
        t.start();

        //阻塞
        return futureTask.get();
    }

    /**
     * lambda写法
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static Object create2() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(() -> {
            log.debug("t2_running");
            Thread.sleep(2000);
            return 2000;
        });

        Thread t = new Thread(futureTask, "t2");
        t.start();

        return futureTask.get();
    }
}
