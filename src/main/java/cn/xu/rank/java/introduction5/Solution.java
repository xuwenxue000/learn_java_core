package cn.xu.rank.java.introduction5;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();

                int x=sc.nextInt();
                String xString=x+"";
                if(x<100){
                    xString="0"+xString;
                }
                int xlength = xString.length();
                if(xlength<3){
                    for(int j=0;j<3-xlength;j++){
                        xString="0"+xString;
                    }
                }
                int length = s1.length();
                if(s1.length()<15){
                    for(int j=0;j<15-length;j++){
                        s1=s1+" ";
                    }
                }
                System.out.println(s1+xString);
                //Complete this line
            }
            System.out.println("================================");

    }
}
