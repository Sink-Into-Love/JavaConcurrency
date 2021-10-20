package com.it.concurrency.javaconcurrency.createThread;

import lombok.extern.slf4j.Slf4j;

/**
 * 继承Thread类创建线程类
 */
@Slf4j(topic = "Thread")
public class create1 {

    public static void main(String[] args) {

        create1();
        create2();
        create3();
        log.debug("create1");
    }

    /**
     * 把线程和任务合并在一起
     */
    public static void create1() {

        Thread t = new Thread() {
            @Override
            public void run() {
                log.debug("t1_running");
            }
        };

        t.setName("t1");
        t.start();
        log.debug("t1_start");
    }

    /**
     * lambda写法（Runnable）
     */
    public static void create2() {

        Thread t = new Thread(() -> log.debug("t2_running"));

        t.setName("t2");
        t.start();
        log.debug("t2_start");
    }

    /**
     * 简写（Runnable）
     */
    public static void create3() {
        Thread t = new Thread(() -> log.debug("t3_running"), "t3");
        t.start();
        log.debug("t3_start");
    }
}
