import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), result, new boolean[nums.length]);
        
        return result;
    }
    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used){
        if(nums.length==current.size()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                current.add(nums[i]);
                backtrack(nums, current, result, used);
                used[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
}
