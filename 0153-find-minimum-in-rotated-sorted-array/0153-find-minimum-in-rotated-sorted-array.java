class Solution {
    public int findMin(int[] nums) {
        int start =0, end = nums.length-1;
        int min=0, mid=0; 
        while(start < end){
            mid = start + (end - start)/2;
            if(mid < end && nums[mid] > nums[mid + 1]) min = mid + 1;
            if(start < mid && nums[mid -1] > nums[mid]) min = mid;

            if(nums[start] <= nums[mid]) start = mid + 1;
            else end = mid -1;
        }
        return nums[min];
    }
}