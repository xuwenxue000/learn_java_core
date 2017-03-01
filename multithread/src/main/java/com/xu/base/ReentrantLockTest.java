package com.xu.base;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by william on 2017/2/24.
 */
public class ReentrantLockTest {

    static int i=0;
    static ReentrantLock lock = new ReentrantLock(true);
    static List list = new LinkedList();
    public static void printtest(String name){
        lock.lock();
        Condition c = lock.newCondition();
        i++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }


    class TestThread implements  Runnable{
        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName()+" run");
            ReentrantLockTest.printtest(Thread.currentThread().getName());
        }
    }

    @Test
    public void test(){

        TestThread t1 = new TestThread();
        for(int i=0;i<100;i++){
            new Thread(t1,"t"+i).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

}
