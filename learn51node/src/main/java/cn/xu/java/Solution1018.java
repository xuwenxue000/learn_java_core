package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * *1018 排序
 基准时间限制：1 秒 空间限制：131072 KB 分值: 0 难度：基础题 收藏  关注
 给出N个整数，对着N个整数进行排序
 Input
 第1行：整数的数量N（1 <= N <= 50000)
 第2 - N + 1行：待排序的整数（-10^9 <= A[i] <= 10^9）
 Output
 共n行，按照递增序输出排序好的数据。
 Input示例
 5
 5
 4
 3
 2
 1
 Output示例
 1
 2
 3
 4
 5
 */
public class Solution1018 {

   public static String  solve(int a, int b){
      String result="";

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