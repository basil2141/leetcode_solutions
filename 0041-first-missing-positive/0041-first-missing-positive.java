class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!= nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }
        int result;
        for(i=0; i<nums.length; i++){
            if(nums[i]!=i+1){
                result = i+1;
                return result;
            }
        }
        return nums.length+1;
    }
    public static void swap(int[] nums, int i, int j){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}