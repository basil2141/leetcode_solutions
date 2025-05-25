class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int smallestDiff=Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            int j=i+1, k = nums.length-1;
            
            while(j<k){
                int currentSum = nums[i]+ nums[j] + nums[k];
                int currentDiff = target-currentSum;

                if(currentDiff==0){
                    return target;
                }

                if((Math.abs(currentDiff)<Math.abs(smallestDiff)) || (Math.abs(currentDiff)==Math.abs(smallestDiff) && currentDiff>smallestDiff)){
                    smallestDiff = currentDiff;
                }

                if(currentDiff>0) j++;
                else k--;

            }

        }
        return target-smallestDiff;
    }
}