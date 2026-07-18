class Solution {
    public boolean canReorderDoubled(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);

        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, Comparator.comparingInt(Math:: abs));

        for(int x : keys){
            int count = map.get(x);

            if(count == 0) continue;
            int counter = 2 * x;
            if(!map.containsKey(counter)) return false;
            if(count > map.get(counter)){
                return false;
            }
            map.put(counter, map.get(counter) - count);
        }
        return true;
    }
}