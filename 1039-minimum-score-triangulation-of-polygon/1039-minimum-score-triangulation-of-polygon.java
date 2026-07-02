class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for(int gap = 0; gap<n; gap++){

            for(int i = 0, j = gap; j<n; j++, i++){

                if(gap == 0) dp[i][j] = 0;
                else if(gap == 1) dp[i][j] = 0;
                else if(gap == 2) {
                    dp[i][j] = values[i] * values[i + 1] * values[j];
                }else{
                    int min = Integer.MAX_VALUE;
                    
                    for(int k = i + 1; k<j; k++){
                        int curr = values[i] * values[k] * values[j];
                        int left = dp[i][k];
                        int right = dp[k][j];
                        int total = curr + left + right;
                        if(min > total) min  = total;
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];
    }
}