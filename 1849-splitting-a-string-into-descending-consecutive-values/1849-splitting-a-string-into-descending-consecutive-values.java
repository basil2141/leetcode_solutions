import java.math.BigInteger;
class Solution {
    public boolean splitString(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            BigInteger firstVal = new BigInteger(s.substring(0, i + 1));
            if(dfs(s, i + 1, firstVal)) return true;
        }
        return false;
    }
    
    public boolean dfs(String s, int index, BigInteger prev) {
        if(s.length() == index) return true;
        
        for(int i = index; i < s.length(); i++) {
            BigInteger current = new BigInteger(s.substring(index, i + 1));
            
            // Check if current = prev - 1
            if(prev.subtract(BigInteger.ONE).equals(current)) {
                if(dfs(s, i + 1, current)) {
                    return true;
                }
            }
        }
        return false;
    }
}
