package cn.xu.learn.thread;

import org.junit.Test;

/**
 * Created by william on 16/5/31.
 */
public class BaseTest {
    @Test
    public void testRunable(){
        new Thread(new Runnable(){
            public void run() {
                //System.out.println("Runnable run");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runnable run");
            }
        }).start();
        System.out.println("Runnable end");
        Runtime.getRuntime().exit(0);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThread(){
        Runnable a = null;
        new Thread(a);
    }
}
