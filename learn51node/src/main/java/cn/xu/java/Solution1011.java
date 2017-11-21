package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 输入2个正整数A，B，求A与B的最大公约数。
 Input
 2个数A,B，中间用空格隔开。(1<= A,B <= 10^9)
 Output
 输出A与B的最大公约数。
 Input示例
 30 105
 Output示例
 15

 碾转相除法


 */
public class Solution1011 {

   public static String  solve(int a, int b){
      String result;
      while(true){
         int c =0;
         int r = 0;
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
            result = r+"";
            break;
         }
      }

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