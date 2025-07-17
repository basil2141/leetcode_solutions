class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        boolean isAscending = nums[0] < nums[n-1];
        if(isAscending){
            for(int i=0; i<n-1; i++){
                if(nums[i+1] < nums[i]) return false;
            }
        }else{
            for(int i=0; i<n-1; i++){
                if(nums[i+1] > nums[i]) return false;
            }
        }
        return true;
    }
}