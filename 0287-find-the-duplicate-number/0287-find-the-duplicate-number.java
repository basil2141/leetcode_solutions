class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        int current = nums[slow];
        int cycleLength=0;
        do{
            current = nums[current];
            cycleLength++;
        }while(current!=nums[slow]);

        return findStart(nums, cycleLength);
    }
    public static int findStart(int[] nums,int cycleLength){
        int p1 = nums[0], p2= nums[0];

        while(cycleLength>0){
            p2 = nums[p2];
            cycleLength--;
        }

        while(p1!=p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}