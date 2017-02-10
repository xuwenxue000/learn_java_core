package cn.xu.learn.base;

/**
 * Created by william on 2017/2/7.
 */
public class KeyWord {

    protected String protectedField="xx";
    private static Integer index=0;
    public void test2(){};
    public   void test(int a){
        try{
            for(int i=0;i<10;i++){
                //System.out.println("22:"+a);
                synchronized ( KeyWordTest2.class){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                    //int b= KeyWordTest2.index;
                    //KeyWordTest2.index = a+KeyWordTest2.index;
                    //System.out.println(b+"+"+a+"="+KeyWordTest2.index);
                    System.out.println(a);
                }

            }
        }catch (Exception e){

        }


    }

    public   void test2(int a){
        try{
            for(int i=0;i<10;i++){
                //System.out.println("22:"+a);
                synchronized (  KeyWordTest2.class){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                    //int b= index;
                    //index = index;
                    //System.out.println(b+"+"+a+"="+index);
                    System.out.println(a);
                }

            }
        }catch (Exception e){

        }


    }
}
