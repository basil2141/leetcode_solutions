class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, 1);
        long sum = 0;
        int count = 0;

        for(int i = 0; i<n; i++){
            sum += (long) nums[i];

            int rem =  (int) (( (sum % k) + k) % k);

            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}