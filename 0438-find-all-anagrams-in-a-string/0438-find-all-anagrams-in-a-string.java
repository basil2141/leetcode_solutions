import java.util.List;
import java.util.HashMap;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int left=0, matched =0;

        for(char c: p.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);

        for(int right =0; right<s.length(); right++){
            char ec = s.charAt(right);    
            if(map.containsKey(ec)){
                map.put(ec, map.get(ec)-1);
                if(map.get(ec)==0) matched++;
            }
            if(matched == map.size()) list.add(left);

            if(right>=p.length()-1){
                char sc = s.charAt(left);
                left++;

                if(map.containsKey(sc)){
                    if(map.get(sc)==0) matched--;
                    map.put(sc, map.getOrDefault(sc, 0)+1);
                }
            }
        }
        return list;
    }
}