package cn.xu.nod51.java;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution1008 {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      int n = in.nextInt();
      int p = in.nextInt();
      long result = 1;
      for(int i=n;i>1;i--){
         result = (result*i)/p;
      }
      out.println(result);
      out.flush();
   }
}