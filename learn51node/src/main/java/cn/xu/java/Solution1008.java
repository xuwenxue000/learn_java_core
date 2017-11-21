package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 输入N和P（P为质数），求N! Mod P = ? (Mod 就是求模 %)
 例如：n = 10， P = 11，10! = 3628800
 3628800 % 11 = 10
 Input
 两个数N,P，中间用空格隔开。(N < 10000, P < 10^9)
 Output
 输出N! mod P的结果。
 Input示例
 10 11
 Output示例
 10
 */
public class Solution1008 {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      int n = in.nextInt();
      int p = in.nextInt();
      long result = 1;
      for(int i=n;i>1;i--){
         result = (result*i)%p;
      }
      out.println(result);
      out.flush();
   }
}