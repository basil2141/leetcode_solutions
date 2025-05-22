import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0, matches=0;
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int right=0; right<s2.length(); right++){
            char endCh = s2.charAt(right);
            if(map.containsKey(endCh)){
                map.put(endCh, map.get(endCh)-1);
                if(map.get(endCh)==0) matches++;
            }
            if(matches == map.size()) return true;

            if(right>= s1.length()-1){
                char startCh = s2.charAt(left);
                left++;
                if(map.containsKey(startCh)){
                    if(map.get(startCh)==0) matches--;
                    map.put(startCh, map.get(startCh)+1);
                }
            }
        }
        return false;
    }
}