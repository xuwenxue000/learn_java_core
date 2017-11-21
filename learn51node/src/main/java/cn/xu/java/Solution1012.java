package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * *输入2个正整数A，B，求A与B的最小公倍数。(LCM)
 Input
 2个数A,B，中间用空格隔开。(1<= A,B <= 10^9)
 Output
 输出A与B的最小公倍数。
 Input示例
 30 105
 Output示例
 210
 */
public class Solution1012 {
   public static int  gcd(int a, int b){
      int r;
      while(true){
         int c;
         if(a>b){
            c = a%b;
            a =c;
            r=b;
         }else{
            c = b%a;
            b = c;
            r = a;
         }
         if(c==0){
            break;
         }
      }

      return r;
   }
   public static String  solve(int a, int b){
      long gcd=  gcd(a,b);
      String result=(a/gcd)*b+"";

      return result;
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      String param = in.nextLine();
      String[] params = param.split(" ");
      out.println(solve(Integer.valueOf(params[0]), Integer.valueOf(params[1])));
      out.flush();
   }
}