class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int i = 0;
        while(i<nums.length){
            if(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(i=0; i<nums.length; i++){
            if(nums[i]!=i+1) result.add(i+1);
        }
        return result;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j]; 
        nums[j] = temp;
    }
}