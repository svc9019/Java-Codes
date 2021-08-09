package com.company;

import java.io.*;
import java.util.*;

public class DSAQuestion2 {

      public static boolean isRotation(String a, String b){
            //Insert your code here
          String reverse = "";
          int temp1 = a.length();
          int temp2 = b.length();

          for (int i = temp2 - 1; i >= 0; i--) {
              reverse = reverse + b.charAt(i);
          }

          if(a.equals(reverse)){
              return true;
          } else{
              return false;
          }
      }
        public static void main(String args[]) throws IOException{

            BufferedReader read= new BufferedReader(new InputStreamReader(System.in));

            String str1=read.readLine();
            String str2=read.readLine();

            if (isRotation(str1, str2)) {
                System.out.println("String equal");
            }
            else {
                System.out.printf("String not equal");
        }
    }
}
