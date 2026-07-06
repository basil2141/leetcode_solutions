class Solution {
    public int distinctSubseqII(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for(int i = 1; i<=n; i++){
            dp[i] =( 2 * dp[i-1] ) % mod ;
            char c = s.charAt(i - 1);
            if(map.containsKey(c)){
                int j = map.get(c);
                dp[i] = (dp[i] - dp[j-1] + mod) % mod;
            }
            map.put(c, i);
        }
        return (int) (dp[n] - 1 + mod) % mod;
    }
}