import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int wStart = 0, maxRepeat=0, maxLength=0;

        for(int wEnd=0; wEnd<s.length(); wEnd++){
            char c = s.charAt(wEnd);
            map.put(c, map.getOrDefault(c,0)+1);
            maxRepeat = Math.max(maxRepeat, map.get(c));

            if((wEnd-wStart+1 - maxRepeat)>k){
                char a = s.charAt(wStart);
                map.put(a, map.get(a)-1);
                wStart++;
            }
            maxLength = Math.max(maxLength, wEnd-wStart+1);
        }
        return maxLength;
    }
}