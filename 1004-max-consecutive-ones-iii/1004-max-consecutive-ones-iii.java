class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;

        int start = 0, len = 0;

        for(int i = 0; i<nums.length; i++){

            if(nums[i] == 0) zeros++;

            while(zeros > k){
                if(nums[start] == 0){
                    zeros--;
                }
                start++;
            }
            len = Math.max(len, i - start + 1);
        }
        return len;
    }
}