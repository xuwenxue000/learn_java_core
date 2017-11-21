package cn.xu;

import cn.xu.java.Solution1012;
import org.junit.Assert;
import org.junit.Test;

/**
 *输入2个正整数A，B，求A与B的最小公倍数。
 Input
 2个数A,B，中间用空格隔开。(1<= A,B <= 10^9)
 Output
 输出A与B的最小公倍数。
 Input示例
 30 105
 Output示例
 210
 */
public class SolutionTest1012 {

   @Test
   public void test(){
      String result = Solution1012.solve(30,105);
      Assert.assertEquals("210",result);

   }
}