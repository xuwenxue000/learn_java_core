package cn.xu.cocurrent;

//import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by william on 2017/2/21.
 */
public class CountDownLatchTest {

    //@Test
    public void test(){
        final  CountDownLatch latch= new CountDownLatch(2);
        final Map<String,String> map=new HashMap();
        new Thread(new Runnable(){
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("1","1");

                map.put("3","3");

                //latch.countDown();
                System.out.println("a");

            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    //Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                map.put("2","2");
                latch.countDown();
                //latch.countDown();
                System.out.println("b");
            }
        }).start();
        try {
            latch.await(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

}
