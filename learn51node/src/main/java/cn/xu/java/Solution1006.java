package cn.xu.java;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 */
public class Solution1006 {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      /**/
      String a = in.nextLine();
      String b = in.nextLine();

      //String a = "abcicba";
      //String b = "abdkscab";
      String result="";
      Integer[][] array =null;
      int al = a.length();
      int bl = b.length();
      array = new Integer[al][bl];
      for(int i=0;i<al;i++){
         for(int j=0;j<bl;j++){
            Integer num=0;
            Integer numa = 0;
            Integer numb = 0;
            if(i>0){
               numa = array[i-1][j];
               if(numa==null){
                  numa=0;
               }
            }
            if(j>0){
               numb = array[i][j-1];
               if(numb==null){
                  numb=0;
               }
            }
            String ai = a.charAt(i)+"";
            String bj = b.charAt(j)+"";
            num=Math.max(numa,numb);
            if(ai.equals(bj)){
               num+=1;
            }
            array[i][j] = num;
            out.print(array[i][j]+" ");
         }
         out.println();
      }

      int i=al-1;int j=bl-1;
      int k = array[i][j];
      for(;i>=0&&j>=0;)
      {
         //out.println(i+","+j+","+result);
         if(k<0)break;
         if(a.charAt(i)==b.charAt(j))
         {
            k--;
            result=a.charAt(i)+result;
            i--;
            j--;
         }
         else
         {
            if(j>0&&i>0&&array[i][j-1]>=array[i-1][j])
               j--;
            else
               if(i>0){
                  i--;
               }else{
                  if(j>0){
                     j--;
                  }
               }
         }
      }
      out.println(result);
      out.flush();
   }


}