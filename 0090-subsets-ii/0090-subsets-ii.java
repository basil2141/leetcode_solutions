class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        int start = 0, end =0;

        for(int i=0; i<nums.length; i++){

            start =0;

            if(i>0 && nums[i] == nums[i-1]) start = end +1;

            end = result.size()-1;
            for(int j =start; j<=end; j++){
                List<Integer> set = new ArrayList<>(result.get(j));
                set.add(nums[i]);
                result.add(set);
            }
        }
        return result;
    }
}