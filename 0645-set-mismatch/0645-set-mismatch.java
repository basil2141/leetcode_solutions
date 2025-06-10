class Solution {
    public int[] findErrorNums(int[] nums) {
        int i =0;
        while(i<nums.length){
            if(nums[i]!=nums[nums[i]-1]){
                swap(nums,i, nums[i]-1);
            }else{
                i++;
            }
        }
        int[] result= new int[2];
        for(i = 0; i<nums.length; i++){
            if(nums[i]!=i+1){
                result[0] = nums[i];
                result[1] = i+1;
                return result;
            }
        }
        return new int[]{-1,-1};
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}