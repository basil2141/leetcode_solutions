class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n= matrix[0].length;

        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;

        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 || j == n-1){
                    if(matrix[i][j] == '1') dp[i][j] = 1;
                    else if(matrix[i][j] == '0') dp[i][j] = 0;
                }else{
                    if(matrix[i][j] == '1'){
                        int right = dp[i][j + 1];
                        int down = dp[i + 1][j];
                        int diag = dp[i + 1][j + 1];
                        dp[i][j] = 1 + ( right < down ? (right < diag ? right : diag) : (down < diag ? down : diag));
                    }
                    else if(matrix[i][j] == '0') dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}