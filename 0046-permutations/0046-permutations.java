class Solution {
    public List<List<Integer>> permute(int[] nums) {
    List< List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> permutations = new LinkedList<>();

    permutations.add(new ArrayList<>());

    for(int num : nums){
        int n = permutations.size();

        for(int i=0; i<n; i++){
            List<Integer> oldPer = permutations.poll();

            for(int j=0; j<= oldPer.size(); j++){
                List<Integer> newPer = new ArrayList<>(oldPer);

                newPer.add(j, num);

                if(newPer.size() == nums.length) result.add(newPer);
                else permutations.add(newPer);
            }
        }
    }
    return result;
    }
}