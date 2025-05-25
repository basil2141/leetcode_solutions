class Solution {
    public void sortColors(int[] nums) {
        int j=0, i=0, k = nums.length-1;

        while(i<=k){
            if(nums[i]==0){
                swap(i, j, nums);
                i++;
                j++;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(i, k, nums);
                k--;
            }
        }
    }
    public static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}