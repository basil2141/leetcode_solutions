class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recursion(dp, nums, 0);
    }
    public int recursion(int[] dp, int[] nums, int index){
        int n = nums.length;
        if(index >= n-1){
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        for(int i = index + 1; i < nums.length && i <= index + nums[index]; i++){
            min = Math.min(min, recursion(dp, nums, i) );
        }
        return dp[index] = (min == Integer.MAX_VALUE ? min : min + 1);
    }
}