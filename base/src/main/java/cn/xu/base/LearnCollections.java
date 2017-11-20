package cn.xu.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by william on 2017/2/21.
 */
public class LearnCollections {

    @Test
    public void array(){
        //1.数据
        String[] stringArray = new String[]{"1","3","4","0","2"};
        //工具类Arrays
        //转换
        List<String> list = Arrays.asList(stringArray);
        //查找(折半查找算法,需要是有序的数组,否则有问题)
        Integer indtx = Arrays.binarySearch(stringArray,"0");
        //基本数据类型的数组是否相同,先判断长度,后循环比对,有一个不同则返回false.
        boolean eq  = Arrays.equals(new int[1],new int[2]);
        //对象数组对比是否相同
        eq = Arrays.deepEquals(stringArray,new String[2]);
        //填充数据,循环赋值
        Arrays.fill(stringArray,"");
        //基本数据数组的hash值
        Arrays.hashCode(new int[1]);
        //对象数据数组的hash值
        Arrays.deepHashCode(stringArray);

    }

    @Test
    public void list(){


        //工具类

        //

    }

}
