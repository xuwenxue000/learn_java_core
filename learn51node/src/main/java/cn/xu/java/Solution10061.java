package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * 这个是连续的
 *给出两个字符串A B，求A与B的最长公共子序列（子序列不要求是连续的）。
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
public class Solution10061 {

    private static void log(String log){
        System.out.print(log);
    }

    private static void logln(String log){ log(log+"\n");
    }

    private static void logln(){
        log("\n");
    }


   public static String solve(String a,String b){
      String result="";
      Integer[][] array =null;
      int al = a.length();
      int bl = b.length();
      array = new Integer[al][bl];
       log("  ");
       for(int i=0;i<bl;i++) {
           log(b.charAt(i) + " ");
       }
      logln();
       int maxLength=0;
       int maxX=0;
       int maxY=0;
      for(int i=0;i<al;i++){
          log(a.charAt(i)+" ");
         for(int j=0;j<bl;j++){
            Integer num=0;
            Integer numPre = 0;

            if(j>0&&i>0){
                numPre = array[i-1][j-1];
               if(numPre==null){
                   numPre=0;
               }
            }
            String ai = a.charAt(i)+"";
            String bj = b.charAt(j)+"";
            //num=Math.max(numa,numb);
            if(ai.equals(bj)){
               num=numPre+1;
               if(num>maxLength){
                   maxLength = num;
                   maxX = i;
                   maxY = j;
               }
            }else{
                num=0;
            }
            array[i][j] = num;
            log(array[i][j]+" ");
         }
          logln();
      }

       result = a.substring(maxX -maxLength+1,maxX+1);
       return result;
   }



   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      /**/
      String a = in.nextLine();
      String b = in.nextLine();

      //String a = "abcicba";
      //String b = "abdkscab";

      out.println(solve(a,b));
      out.flush();
   }


}