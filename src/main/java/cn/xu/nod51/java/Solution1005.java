package cn.xu.nod51.java;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Solution1005 {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      String a = in.nextLine();
      String b = in.nextLine();
      out.println(new BigDecimal(a).add(new BigDecimal(b)));
      out.flush();
   }
}