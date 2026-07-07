class Solution {
    public int countPalindromicSubsequences(String s) {
        int mod = 1000000000 + 7;
        int n = s.length();
        int[][] dp =  new int[n][n];
        Map<Character, Integer> map = new HashMap<>();

        int[] next = new int[n];
        int[] prev= new int[n];
        for(int i = n-1; i>=0; i--){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                next[i] = map.get(c);
            }else{
                next[i] = n;
            }
            map.put(c, i);
        }
        map.clear();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                prev[i] = map.get(c);
            }else{
                prev[i] = -1;
            }
            map.put(c, i);
        }
        for(int gap = 0; gap<n; gap++){
            for(int i = 0, j = gap; j<n; j++,i++){

                if(gap == 0) dp[i][j] = 1;
                else {
                    if(s.charAt(i) != s.charAt(j)){
                        dp[i][j] = (int) (( 0L + dp[i+1][j] + dp[i][j -1] - dp[i+1][j-1] + mod) % mod);
                    }else{
                        int i1 = next[i];
                        int i2 = prev[j];

                        if(i1  > i2){
                            dp[i][j] = (int) ((2L * dp[i + 1][j-1] + 2) %mod);
                        }else if(i1 == i2){
                            dp[i][j] =  (int) ((2L * dp[i + 1][j-1] + 1) % mod);
                        }else{
                            dp[i][j] =  (int)( (2L*dp[i + 1][j-1] - dp[i1 + 1][i2-1] + mod) % mod);
                        }
                    }
                }
            }
        }
        return dp[0][n-1] % mod;
    }
}