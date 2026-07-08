class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return recursion(dp, s, p, 0, 0);
    }

    public boolean recursion(Boolean[][] dp, String s, String p, int i1, int i2){
        // Base case 1: Both string and pattern are fully exhausted
        if (i1 == s.length() && i2 >= p.length()) {
            return true;
        }

        // Base case 2: Pattern is exhausted, but string still has characters
        if (i1 < s.length() && i2 >= p.length()) {
            return false;
        }

        // Base case 3: String is exhausted, but pattern still has characters
        // Complex Base Case: Can the rest of the pattern vanish to empty?
        if (i1 == s.length() && i2 < p.length()) {
            // We must jump by 2 because a vanishing token is a pair (e.g., "a*", "b*")
            for (int i = i2; i < p.length(); i += 2) {
                // If there's a dangling character without a '*', or the next char isn't '*', it can't vanish
                if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i1][i2] != null) return dp[i1][i2];

        char ch = p.charAt(i2);
        Character nextCh = null;
        if (i2 + 1 < p.length()) nextCh = p.charAt(i2 + 1);
        
        boolean result = false;
        
        // 2. ASTERISK-FIRST LOGIC
        if (nextCh != null && nextCh == '*') {
            // Option A: Vanish the pair (Zero occurrences). 
            result = recursion(dp, s, p, i1, i2 + 2);
            
            // Option B: Consume one character (One or more occurrences).
            if (!result && (ch == s.charAt(i1) || ch == '.')) {
                result = recursion(dp, s, p, i1 + 1, i2);
            }
        } 
        // 3. NO ASTERISK (Standard Match)
        else {
            if ( (ch == s.charAt(i1) || ch == '.')) {
                result = recursion(dp, s, p, i1 + 1, i2 + 1);
            } else {
                result = false;
            }
        }
        
        return dp[i1][i2] = result;
    } 
}