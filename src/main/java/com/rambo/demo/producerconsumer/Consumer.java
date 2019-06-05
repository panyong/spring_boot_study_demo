package com.rambo.demo.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * User: za-panyong
 * Date: 2019/5/24
 * Time: 18:13
 */
public class Consumer extends Thread {
    private ArrayBlockingQueue<Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue, String name) {
        super(name);
        this.queue = queue;
        System.out.println("初始化消费者"+this.getName());
    }

    @Override
    public void run() {
        System.out.println(this.getName()+"消费开始");
        consume();
    }

    private void consume() {
        while (true){
            try {
                Integer c = queue.take();
                System.out.println(this.getName()+"消费了1一个元素："+c);
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}
