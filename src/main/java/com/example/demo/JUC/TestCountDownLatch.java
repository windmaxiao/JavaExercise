package com.example.demo.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * 如何在执行完10个任务之后再执行第二阶段
 * @author maxiao
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 10;
        CountDownLatch latch = new CountDownLatch(nThreads);

        // 创建10个线程并启动
        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(new Task(latch));
            thread.start();
        }

        // 等待所有线程执行完毕
        latch.await();

        // 执行第二阶段任务
        System.out.println("第一阶段任务全部完成，执行第二阶段任务");
    }

    static class Task implements Runnable {
        private CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            // 执行任务
            System.out.println(Thread.currentThread().getName() + "开始执行任务");
            try {
                Thread.sleep(1000); // 模拟任务执行过程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "任务执行完毕");

            // 计数器减1
            latch.countDown();
        }
    }
}
