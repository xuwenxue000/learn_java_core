package cn.xu.base;

import org.junit.Test;

public class ThreadTest {
    ThreadLocal threadLocal = new ThreadLocal(){

    };

    @Test
    public void test1(){
        System.out.print("000");
        synchronized (this){
            try {
                Thread.sleep(1000);
                this.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("111");
        }
    }
}
