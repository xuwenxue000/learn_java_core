package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
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
public class Solution1006 {

    private static void log(String log){
        //System.out.print(log);
    }

    private static void logln(String log){ log(log+"\n");
    }

    private static void logln(){
        log("\n");
    }

   public static String solve(String a,String b){
      String result;
      int[][] array;
      int al = a.length();
      int bl = b.length();
      array = new int[al][bl];
       log("  ");
       //for(int i=0;i<bl;i++) {
       //    log(b.charAt(i) + " ");
       //}
      //logln();
       int maxLength=0;
       int maxX=0;
       int maxY=0;
      for(int i=0;i<al;i++){
          //log(a.charAt(i)+" ");
         for(int j=0;j<bl;j++){
            int num=0;
            int numPre = 0;

            int numl = 0;
            int numt = 0;
             if(i>0){
                 numl = array[i-1][j];
             }
             if(j>0){
                 numt = array[i][j-1];
             }
            if(j>0&&i>0){
                numPre = array[i-1][j-1];
            }
            String ai = a.charAt(i)+"";
            String bj = b.charAt(j)+"";
            int numMax=Math.max(numl,numt);
            if(ai.equals(bj)){
               num=numPre+1;
               if(j<bl-1){
                   array[i][j+1] +=1;
               }
                if(i<al-1){
                    array[i+1][j] +=1;
                }
               if(num>=maxLength){
                   maxLength = num;
                   maxY = i;
                   maxX = j;
               }
            }else{
                num=numMax;
            }
            array[i][j] = num;
            //log(array[i][j]+" ");
         }
          //logln();
      }
       StringBuilder stringBuilder = new StringBuilder();
       int j=maxX;
       int i=maxY;

       while(i>=0&&j>=0){
           String c = a.charAt(i)+"";
           //int nump = 0;

           int numl = 0;
           int numt = 0;
           if(i>0){
               numl = array[i-1][j];
           }
           if(j>0){
               numt = array[i][j-1];
           }
           //if(j>0&&i>0){
           //    nump = array[i-1][j-1];
           //}
           int num = array[i][j];
           //log("x:"+j);
           //log(";y:"+i);
           //log(";numl:"+numl);
           //log(";numt:"+numt);
           //log(";nump:"+nump);

           if(numl==numt&&num==numt+1){
               stringBuilder.append(c);
               //array[i][j]=0;
               //log(c);
               i--;
               j--;
           }else{
               if(numt>numl){
                   j--;
               }else{
                   i--;
               }

           }
           //logln(";num:"+num);

       }
       //log(array);
       result = stringBuilder.reverse().toString();

       return result;
   }

   private static void log(int[][] array){

        int al = array.length;
        int bl = array[0].length;
       for(int i=0;i<al;i++) {
           for (int j = 0; j < bl; j++) {
               log(array[i][j]+" ");
           }
           logln();
       }
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