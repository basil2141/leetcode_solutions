class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,nOnes=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1) nOnes++;
            if(nums[i]==0) nOnes=0;
            max = Math.max(max, nOnes);
        }
        return max;
    }
}