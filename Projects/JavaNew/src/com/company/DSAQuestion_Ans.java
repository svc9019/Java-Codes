BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
        String s=read.readLine();
        HashMap<Character,Integer> hs=new HashMap<>();
        String re="";
        HashSet<Character> set=new HashSet<Character>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++)
        {
            set.add(chars[i]);
        }
        Iterator<Character> iterator=set.iterator();
        String sbSt=new String();
        while(iterator.hasNext())
        {
            sbSt=sbSt + iterator.next() + " ";
        }

        System.out.println(sbSt);
}
}