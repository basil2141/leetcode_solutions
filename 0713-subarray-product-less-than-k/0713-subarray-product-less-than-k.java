class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0, product=1, n=0;
        if(k<=1) return 0;
        
        for(int right=0; right<nums.length; right++){
                product *=nums[right];
            while(left<nums.length && product>=k) product /= nums[left++];

            n +=  right -left +1;
        }
        return n;
    }
}