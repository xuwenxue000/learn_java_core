package cn.xu.java;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 给出2个大整数A,B，计算A+B的结果。
 Input
 第1行：大数A
 第2行：大数B
 (A,B的长度 <= 10000 需注意：A B有可能为负数）
 Output
 输出A + B
 Input示例
 68932147586
 468711654886
 Output示例
 537643802472
 */
public class Solution1005 {

   public static String add(String a,String b){
      //return new BigDecimal(a).add(new BigDecimal(b)).toString();
       int alen = a.length();
       int blen = b.length();
       StringBuilder result =new StringBuilder();
       int last=0;
       for(int i=0;i<alen||i<blen;i++){
            int an =0;
            if(i<alen){
                an = Integer.valueOf(a.charAt(alen-i-1)+"");
            }
            int bn =0;
            if(i<blen){
                bn = Integer.valueOf(b.charAt(blen-i-1)+"");
            }
            int n = an+bn;
            n=n+last;
            if(n>=10){
                last=n/10;
                n = n%10;
            }else{
                last=0;
            }
            //System.out.println(an+"+"+bn+"="+n +" %"+last);
            result.append(n);
       }
       if(last>0){
           result.append(last);
       }
       return result.reverse().toString();
   }
    public static String minus(String a,String b,boolean lt){
        //return new BigDecimal(a).add(new BigDecimal(b)).toString();
        int alen = a.length();
        int blen = b.length();
        if(a.equals(b)){
            return "0";
        }
        if(alen<blen){
            return "-"+minus(b,a,true);
        }
        if(alen==blen&&!lt){
            for(int i=0;i<alen;i++){
                int an = Integer.valueOf(a.charAt(i)+"");
                int bn = Integer.valueOf(b.charAt(i)+"");
                if(bn>an){
                    return "-"+minus(b,a,true);
                }
                if(bn<an){
                    break;
                }

            }
        }
        StringBuilder result =new StringBuilder();
        int last=0;
        for(int i=0;i<alen||i<blen;i++){
            int an =0;
            if(i<alen){
                an = Integer.valueOf(a.charAt(alen-i-1)+"");
            }
            int bn =0;
            if(i<blen){
                bn = Integer.valueOf(b.charAt(blen-i-1)+"");
            }
            int n = an-bn-last;
            if(n<0){
                n+=10;
                last=1;
            }else{
                last=0;
            }
            //System.out.println(an+"+"+bn+"="+n +" %"+last);
            result.append(n);
        }
        while(result.toString().endsWith("0")){
            result.deleteCharAt(result.length()-1);
        }
        if(last>1){
            result.append("-");
        }
        return result.reverse().toString();
    }


   public static String addSign(String a,String b){
       boolean aPlus=true;
       boolean bPlus=true;
       if(a.startsWith("-")){
           aPlus=false;
           a = a.substring(1);

       }
       if(b.startsWith("-")){
           bPlus=false;
           b = b.substring(1);
       }
       if(aPlus&&bPlus){
           return add(a,b);
       }
       if(!aPlus&&!bPlus){
           return "-"+add(a,b);
       }

       if(aPlus){
           return minus(a,b,false);
       }
       if(bPlus){
           return minus(b,a,false);
       }
       return "";
   }



   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      String a = in.nextLine();
      String b = in.nextLine();
      out.println(addSign(a,b));
      out.flush();
   }
}