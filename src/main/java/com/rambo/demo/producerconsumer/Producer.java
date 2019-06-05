package com.rambo.demo.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * User: za-panyong
 * Date: 2019/5/24
 * Time: 18:10
 */
public class Producer extends Thread {
    private ArrayBlockingQueue<Integer> queue;
    private static Integer begin;

    public Producer(ArrayBlockingQueue<Integer> queue, String name) {
        super(name);
        this.queue = queue;
        begin = 0;
        System.out.println("初始化生产者" + this.getName());
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "生产开始");
        produce();
    }

    private void produce() {
        while (true) {
            synchronized (queue) {
                try {
                    queue.put(++begin);
                    System.out.println(this.getName() + "生产了1一个元素：" + begin);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
