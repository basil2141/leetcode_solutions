class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l =Integer.MAX_VALUE, wSum=0, wStart=0;
        for(int wEnd=0; wEnd<nums.length; wEnd++){
            wSum = wSum + nums[wEnd];
            
            if(wSum>=target){
                while(wSum>=target) {
                    l = Math.min(l, wEnd-wStart+1);
                    wSum -= nums[wStart];
                    wStart++;
                }
            }
        }
        return l==Integer.MAX_VALUE?0:l;
    }
}