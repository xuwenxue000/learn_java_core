package cn.xu;

import cn.xu.java.Solution1005;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 给出2个大整数A,B，计算A+B的结果。
 Input
 第1行：大数A
 第2行：大数B
 (A,B的长度 <= 10000 需注意：A B有可能为负数）
 Output
 输出A + B
 Input示例
 68932147586
 468711654886
 Output示例
 537643802472
 */
public class SolutionTest1005 {

   @Test
   public void test(){
      String result = Solution1005.add("68932147586","468711654886");
      System.out.println("68932147586,468711654886");
      Assert.assertEquals("537643802472",result);
   }
}