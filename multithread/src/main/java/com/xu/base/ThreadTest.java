package com.xu.base;

import org.junit.Test;

/**
 * Created by william on 2017/2/17.
 */
public class ThreadTest {
    /**
     *输出简单线程信息
     */
    class RunableTest1 implements Runnable{
        @Override
        public  void run(){
            Thread thread = Thread.currentThread();
            System.out.println(thread.getId()+";"+thread.getName()+";RunableTest1 run");

        }
    }




    /**
     * 输出当前线程的信息,ID,name
     */
    @Test
    public void  test1(){
        Runnable runableTest1 = new RunableTest1();
        Thread thread1 = new Thread(runableTest1,"runableTest1");
        thread1.start();
    }

    /**
     *yield
     */
    class RunableTest2 implements Runnable{
        @Override
        public  void run(){
            Thread thread = Thread.currentThread();

            for(int i=0;i<10;i++){
                System.out.println(i+";"+thread.getId()+";"+thread.getName()+";run");
                thread.yield();
            }


        }
    }

    /**
     * yield
     */
    @Test
    public void  test2(){
        Runnable runableTest21 = new RunableTest2();
        Thread thread1 = new Thread(runableTest21,"runableTest21");
        thread1.start();

        Runnable runableTest22 = new RunableTest2();
        Thread thread2 = new Thread(runableTest22,"runableTest22");
        thread2.start();
    }


    /**
     *
     */
    class RunableTest3 implements Runnable{
        @Override
        public  void run(){
            try{
                Thread thread = Thread.currentThread();
                this.wait();
                for(int i=0;i<10;i++){
                    Thread.sleep(100);
                    System.out.println(i+";"+thread.getId()+";"+thread.getName()+";run");

                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }
    }
    /**
     * 测试join
     */
    @Test
    public void  test3(){
        Runnable runableTest3 = new RunableTest3();
        Thread thread1 = new Thread(runableTest3,"RunableTest3");
        thread1.start();
        try{
           thread1.join(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }
        while(thread1.isAlive()){

        }
        System.out.println("ok");
    }

    /**
     *
     */
    class RunableTest4 implements Runnable{
        @Override
        public  void run(){
            try{
                Thread thread = Thread.currentThread();
                for(int i=0;i<10;i++){
                    System.out.println(i+";"+thread.getId()+";"+thread.getName()+";run");
                    synchronized(thread){
                        thread.wait();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }
    }
    /**
     * 测试waite
     */
    @Test
    public void  test4(){
        Runnable runableTest = new RunableTest4();
        Thread thread1 = new Thread(runableTest,"RunableTest4");

        thread1.start();
        try{
            while(thread1.isAlive()){
                synchronized (thread1){

                    System.out.println("xxx");
                    thread1.notifyAll();
                }
            }


            thread1.join(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }
        while(thread1.isAlive()){

        }
        System.out.println("ok");
    }

}
