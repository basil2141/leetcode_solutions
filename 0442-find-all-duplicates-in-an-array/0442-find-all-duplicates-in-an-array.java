class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i<nums.length){
            if(nums[i] != nums[nums[i]-1]){
                swap(nums,i, nums[i]-1);
            }else{
                i++;
            }
        }

        for(i=0; i<nums.length; i++){
            if(nums[i]!=i+1){
                result.add(nums[i]);
            }
        }
        return result;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}