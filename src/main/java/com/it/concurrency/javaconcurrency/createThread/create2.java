package com.it.concurrency.javaconcurrency.createThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Runnable")
public class create2 {

    public static void main(String[] args) {

        create1();
        create2();
        create3();
        log.debug("create2");
    }

    /**
     * 把线程和任务分开
     */
    public static void create1() {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                log.debug("t1_running");
            }
        };

        Thread t = new Thread(r, "t1");
        t.start();
        log.debug("t1_start");
    }

    /**
     * lambda写法
     */
    public static void create2() {

        Runnable r = () -> log.debug("t2_running");

        Thread t = new Thread(r, "t2");
        t.start();
        log.debug("t2_start");
    }

    /**
     * 简写
     */
    public static void create3() {
        Thread t = new Thread(() -> log.debug("t3_running"), "t3");
        t.start();
        log.debug("t3_start");
    }
}
