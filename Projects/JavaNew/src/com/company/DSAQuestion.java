package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


public class DSAQuestion {

    public static void main(String[] args) throws Exception  {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();
//        int n = s.length();
        HashMap<Character,Integer> hs = new HashMap<>();
//        LinkedHashSet<Character> lhs = new LinkedHashSet<>();
        String re = "";
//        for(int i=0;i<n;i++)
//            lhs.add(s.charAt(i));
//        for(Character ch: lhs)
//            System.out.print(ch);

        for(Character i: s.toCharArray()){
            hs.put(i,s.length());
        }
        for(Map.Entry<Character, Integer> m: hs.entrySet()){
            System.out.print(m.getKey());
        }
    }
    //System.out.println(re);
}
