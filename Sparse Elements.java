package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class SparseElements {
    public static void main(String[] args){
        Scanner count = new Scanner(System.in);

        String Str = count.nextLine();

        String[] s = Str.split(",");

        Map<String,Integer> map = new HashMap<String,Integer>();

        for(String st: s){
            Integer old = map.get(st);

            if(old == null){
                old = 0;
            }
            map.put(st,old+1);
        }
        System.out.println(map);
    }
}
