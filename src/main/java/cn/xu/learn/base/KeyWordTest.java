package cn.xu.learn.base;

/**
 * Created by william on 2017/2/7.
 */
public class KeyWordTest {
    public static void main(String[] args){
        /**
         * protected的同包下可以访问
         */
        String a = new KeyWord().protectedField;
    }
}
