package cn.xu.learn.datatype;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 16/8/22.
 */
public class DataTypeLearn {

    /**
     *
     */
    @Test
    public void testBoolean(){
        Boolean b =Boolean.FALSE;
        Boolean a = new Boolean(true);
        Boolean c = new Boolean("true");
        Boolean d = true;
        Boolean e = Boolean.valueOf("true");

        System.out.println(a&b&c&d&e);
    }



    @Test
    public void testByte(){
        Byte a = new Byte("2");
        Byte b=2;
        Byte c =Byte.valueOf("2");
        //Byte b =Byte.parseByte("2");

    }
}
