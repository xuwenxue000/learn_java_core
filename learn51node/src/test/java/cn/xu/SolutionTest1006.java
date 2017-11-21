package cn.xu;

import cn.xu.java.Solution1005;
import cn.xu.java.Solution1006;
import org.junit.Assert;
import org.junit.Test;

/**
 * 给出两个字符串A B，求A与B的最长公共子序列（子序列不要求是连续的）。
 比如两个串为：

 abcicba
 abdkscab

 ab是两个串的子序列，abc也是，abca也是，其中abca是这两个字符串最长的子序列。
 Input
 第1行：字符串A
 第2行：字符串B
 (A,B的长度 <= 1000)
 Output
 输出最长的子序列，如果有多个，随意输出1个。
 Input示例
 abcicba
 abdkscab
 Output示例
 abca
 */
public class SolutionTest1006 {

   @Test
   public void test(){
      String result = Solution1006.solve("abcicba","abdkscab");
      Assert.assertEquals("abca",result);


   }
}