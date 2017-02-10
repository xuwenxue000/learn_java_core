package cn.xu.learn.base;

import java.security.Key;
import java.util.Map;

/**
 * Created by william on 2017/2/7.
 */
public class KeyWordTest {

    public  KeyWordTest(){}

    public static void main(String[] args) throws  Exception{
        /**
         * protected的同包下可以访问
         */
        //String a = new KeyWord().protectedField;


        //test1();
        //System.out.println(test2());
        final KeyWord keyWord = new KeyWord();
        final KeyWord keyWord1 = new KeyWord();
        final KeyWord keyWord2 = new KeyWord();
        new Thread(new Runnable() {
            public void run()  {
                keyWord.test(1);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                keyWord2.test2(2);
            }
        }).start();
    }

    public static void test1() throws Exception{
        try{
            System.out.println("try");
            throw new Exception();
        }catch (Exception e){
            System.out.println("catch");
            throw new Exception("catch");
        }finally {
            System.out.println("finally");
            throw new Exception("finally");
        }
    }

    public strictfp  static int test2() throws Exception{
        int a=1;
        try{
            System.out.println("try");

            return a/0;
        }catch (Exception e){
            System.out.println("catch");
            a=2;
            return a;
        }finally {
            a=3;
            System.out.println("finally");

            return a;
        }

       // KeyWordTest.class.isInstance(new Object());
    }
}
