package cn.xu;

import cn.xu.java.Solution1011;
import cn.xu.java.SolutionTemp;
import org.junit.Assert;
import org.junit.Test;

/**
 *输入2个正整数A，B，求A与B的最大公约数。
 Input
 2个数A,B，中间用空格隔开。(1<= A,B <= 10^9)
 Output
 输出A与B的最大公约数。
 Input示例
 30 105
 Output示例
 15
 */
public class SolutionTest1011 {

   @Test
   public void test(){
      String result = Solution1011.solve(30,105);
      Assert.assertEquals("15",result);


   }
}