package cn.xu.nod51.java;

import java.io.*;
import java.util.*;

/**
 *
 给出2个整数A和B，计算两个数的和。
 Input
 2个整数A B，中间用空格分割。（0 <= A, B <= 10^9）
 Output
 输出A + B的计算结果。
 Input示例
 1 2
 Output示例
 3
 */
public class Solution1000 {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      out.println(Integer.MAX_VALUE);
      int a = in.nextInt();
      int b = in.nextInt();
      out.println(a + b);
      out.flush();
   }
}