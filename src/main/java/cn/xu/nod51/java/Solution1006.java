package cn.xu.nod51.java;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class Solution1006 {

   class Node {
      Integer level;
      String name;
      Node parent;
      Integer i;
      Integer j;
   }


   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      /*
      String a = in.nextLine();
      String b = in.nextLine();
      */
      Map<String,Node> map = new HashMap<String, Node>();
      String a = "abcicba";
      String b = "abdkscab";
      Integer[][] array =null;
      array = new Integer[a.length()][b.length()];
      String result = getResult(0,0,a,b,array,"");
      System.out.println(result);
      for(int i=0;i<array.length;i++){
         for(int j=0;j<array[i].length;j++){
            /*Integer num=0;
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
            String key = i+"_"+j;
            num=Math.max(numa,numb);
            if(ai.equals(bj)){
               num+=1;

            }

            array[i][j] = num;*/
            out.print(array[i][j]+" ");
         }
         out.println();
      }
      out.flush();
   }
   public static  int xxx=1;

   public static  String getResult(int i,int j,String a,String b,Integer[][] array,String preR){
      xxx++;
      String resulut=preR;
      if(i==a.length()){
         return preR;
      }
      if(j==b.length()){
         return preR;
      }
      String ai = a.charAt(i)+"";
      String bj = b.charAt(j)+"";
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
      num=Math.max(numa,numb);
      if(ai.equals(bj)){
         num+=1;
         preR+=ai;
         System.out.println("xxx: "+xxx+" i:"+i+" j:"+j+" ai:"+ai+" preR:"+preR);
         String resulta = getResult(i+1,j+1,a,b,array,preR);
         array[i][j] = num;
         if(resulta.length()>resulut.length()){
            resulut=resulta;
         }
      }else{
         String resulta = getResult(i+1,j,a,b,array,preR);
         String resultb = getResult(i,j+1,a,b,array,preR);
         if(resulta.length()>resulut.length()){
            resulut=resulta;
         }
         if(resultb.length()>resulut.length()){
            resulut=resultb;
         }
      }
      return resulut;
   }
}