import java.util.ArrayList;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result=Double.NEGATIVE_INFINITY, average=0;
        ArrayList<Double> list = new ArrayList<>();
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(i>=k-1){
            average = sum/(double)k;
            list.add(average);
            sum = sum - nums[i-k+1];
            }
        }
        for(int i=0; i<nums.length-k+1; i++){
            if(list.get(i)>result){
                result = list.get(i);
            }
        }
        return result;
    }
}