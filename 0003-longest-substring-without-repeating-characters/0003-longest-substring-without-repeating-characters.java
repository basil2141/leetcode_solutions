import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int wStart=0, maxL=Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int wEnd =0; wEnd<s.length(); wEnd++){
            char rightC = s.charAt(wEnd);
            if(map.containsKey(rightC)){
                wStart = Math.max(wStart, map.get(rightC)+1);
            }
            map.put(rightC, wEnd);
            maxL = Math.max(maxL, wEnd-wStart+1);
        }
        return maxL==Integer.MIN_VALUE?0:maxL;
    }
}