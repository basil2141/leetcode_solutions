class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        result[0] = search(target, nums, false);
        if(result[0] != -1) result[1] = search(target, nums, true);
        return result;   
    }
    public static int search(int key, int[] nums, boolean findMaxIndex){
        int index = -1;
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(key < nums[mid]) end = mid -1;
            else if(key > nums[mid]) start = mid + 1;
            else{
                index = mid;
                if(findMaxIndex) start = mid + 1;
                else end = mid - 1;
            }
        }
        return index;
    }
}