class Solution {
    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return recursion(dp, s, p, 0, 0);
    }
    public boolean recursion(Boolean[][] dp, String s, String p, int i1, int i2){
        if(i1 ==s.length() && i2 == p.length()) {
            return dp[i1][i2] =  true;
        }
        if(i1 < s.length() && i2 == p.length()) return dp[i1][i2] = false;
        if(i1 == s.length() && i2 < p.length()){
            for(int i = i2; i<p.length(); i++){
                if(p.charAt(i) != '*') return dp[i1][i2] = false;
            }
            return dp[i1][i2] = true;
        }
        if(dp[i1][i2] != null) return dp[i1][i2];
            char ch = p.charAt(i2);
            boolean result = false;
            if(ch == '*'){
             
                    result = result || recursion(dp, s,p, i1, i2 + 1) || recursion(dp, s,p, i1 +1, i2) ;
 
            }else if(ch == '?'){
                result = result || (recursion(dp, s, p, i1 + 1, i2 + 1));
            }else if(ch != s.charAt(i1)){
                result = false;
            }else if(ch == s.charAt(i1)){
              result = recursion(dp, s, p, i1 + 1, i2 + 1);
            }
        return dp[i1][i2] = result;
    }
}