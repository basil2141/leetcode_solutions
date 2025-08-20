class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, result, 0, new ArrayList<>(), 0, target);
        return result;
    }
    public void dfs(int[] arr, List<List<Integer>> result, int index, List<Integer> current, int currentSum, int target){
        if(currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index >= arr.length || currentSum > target){
            return;
        }

        // decision-1
        current.add(arr[index]);
        dfs(arr, result, index, current, currentSum + arr[index], target);
        current.remove(current.size()-1);

        // decision-2
        dfs(arr, result, index + 1, current, currentSum, target);
    }
}