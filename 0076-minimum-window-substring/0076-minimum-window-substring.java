import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0, minL = s.length()+1, matched=0, subStrStart=0;

        for(char c: t.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);

        for(int right=0; right<s.length(); right++){
            char ec = s.charAt(right);
            if(map.containsKey(ec)){
                map.put(ec, map.get(ec)-1);
                if(map.get(ec)>=0) matched++;
            }

            while(matched==t.length()){
                if(minL > right-left+1){
                    minL = right-left+1;
                    subStrStart = left;
                }

                char sc = s.charAt(left++);
                if(map.containsKey(sc)){
                    if(map.get(sc)==0) matched--;
                    map.put(sc, map.getOrDefault(sc,0)+1);
                }
            }
        }
        return minL>s.length() ?"":s.substring(subStrStart, subStrStart+minL); 
    }
}