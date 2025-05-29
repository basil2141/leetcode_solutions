class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            int fast = i, slow = i;
            boolean  isForward = nums[i]>0;
            do{
                slow = getIndex(nums, isForward, slow);
                fast = getIndex(nums, isForward, fast);
                if(fast!=-1) fast = getIndex(nums, isForward, fast);
            }while(slow!=-1 && fast!=-1 && slow!=fast);

            if(slow!=-1 && slow == fast) return true;
        }
        return false;
    }
    public static int getIndex(int[] nums, boolean isForward, int currentIndex){
        boolean direction = nums[currentIndex]>0;

        if(isForward!=direction) return -1;

        int nextIndex = (currentIndex + nums[currentIndex])%nums.length;
        if(nextIndex<0) nextIndex += nums.length;

        if(currentIndex==nextIndex) return -1;

        return nextIndex;
    }
}