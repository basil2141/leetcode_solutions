class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1; arr[n + 1] = 1;
        for(int i =  0; i<n; i++) arr[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for(int[] arr1 : dp) Arrays.fill(arr1, -1);
        return recursion(dp, arr, 1, n);
    }
    public int recursion(int[][] dp, int[] nums, int start, int end){
        if(start > end) {
            return  dp[start][end] = 0; 
        }
        if(dp[start][end] != -1) return dp[start][end];
        int ans = Integer.MIN_VALUE;
        for(int k = start; k<=end; k++){
            int left = recursion(dp, nums, start, k-1);
            int right = recursion(dp, nums, k+1, end);
            int cost = left + right + nums[k] * nums[start- 1] * nums[end + 1];
            if(cost > ans) ans = cost;
        }
        return dp[start][end] = ans;
    }
}