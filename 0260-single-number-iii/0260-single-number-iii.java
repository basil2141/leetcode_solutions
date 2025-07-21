class Solution {
    public int[] singleNumber(int[] nums) {
        int n1xn2 = 0;
        for(int n : nums) n1xn2 ^= n;

        int rightMost = 1;
        while((rightMost & n1xn2) == 0){
            rightMost = rightMost << 1;
        }
            int n1 = 0, n2 =0;
        for(int n : nums){
            if( (n & rightMost) !=0) n1 ^=n;
            else n2 ^=n;
        }
        return new int[]{n1,n2};
    }
}