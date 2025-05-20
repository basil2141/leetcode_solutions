class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0, nOnes=0, left=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]==1) nOnes++;

            if((right-left+1 - nOnes)>k){
                if(nums[left]==1) nOnes--;
                left++;
            }
            max = Math.max(right-left+1, max);
        }
        return max;
    }
}