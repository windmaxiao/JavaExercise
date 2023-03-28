package com.example.demo.JUC;

import java.util.*;
import java.util.concurrent.*;

/**
 * 简单线程池和执行
 * @author maxiao
 */
public class ThreadPoolTest {

    static ExecutorService threadPoolExecutor;

    static {
        buildTreadPool();
    }

    public static void buildTreadPool() {
        threadPoolExecutor
                = new ThreadPoolExecutor(3, 5, 10L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }



    public static void testThreadPool (int num) {
        for (int i = 0; i < num; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(System.currentTimeMillis() + "==>>>>>" + Thread.currentThread().getName() + "=====>正在处理");
            });
        }

        threadPoolExecutor.shutdown();
    }



    public String getInfo(String id) throws InterruptedException {
        Thread.sleep(2000);
        return id + "基本信息";
    }

    public List<String> getImg(String id) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add("1");
        imgs.add("2");
        imgs.add("3");

        return imgs;
    }

    public String getExt(String id) throws InterruptedException {
        Thread.sleep(2000);
        return id + "ext.....";
    }

    /**
     * 单线程执行任务
     * @param id id
     * @return Map
     * @throws InterruptedException InterruptedException
     */
    public Map<String, Object> getMsgBySingleThread(String id) throws InterruptedException {

        long start = System.currentTimeMillis();

        Map<String, Object> map = new HashMap<>();

        map.put("Info", getInfo(id));
        map.put("img", getImg(id));
        map.put("ext", getExt(id));

        System.out.println((System.currentTimeMillis() - start) + "ms");

        return map;

    }

    /**
     * 多线程执行任务
     * @param id id
     * @return Map
     * @throws InterruptedException InterruptedException
     * @throws ExecutionException ExecutionException
     */
    public Map<String, Object> getMsgByThreadPool(String id) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        Map<String, Object> map = new HashMap<>();

        Future<?> info = threadPoolExecutor.submit(() -> {
            try {
                getInfo(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<?> img = threadPoolExecutor.submit(() -> {
            try {
                getImg(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<?> ext = threadPoolExecutor.submit(() -> {
            try {
                getExt(id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        map.put("Info", info.get());
        map.put("img", img.get());
        map.put("ext", ext.get());

        System.out.println((System.currentTimeMillis() - start) + "ms");

        threadPoolExecutor.shutdown();

        return map;

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        // threadPoolExecutor.shutdown();

        testThreadPool(6);

        ThreadPoolTest threadPoolTest = new ThreadPoolTest();

        System.out.print("单线程执行时间：");
        Map<String, Object> msgBySingleThread = threadPoolTest.getMsgBySingleThread("1");
        System.out.print("多线程执行时间：");
        Map<String, Object> msgByThreadPool = threadPoolTest.getMsgByThreadPool("1");
    }
}
