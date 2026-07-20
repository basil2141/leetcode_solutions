class Solution {
    public int[] avoidFlood(int[] rains) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = rains.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){

            if(rains[i] > 0){
                ans[i] = -1;
                if(map.containsKey(rains[i])){
                    int lb = bs(list, map.get(rains[i]));
                    
                    if(lb == -1) return new int[]{};
                    else{
                        int index = list.get(lb);
                        ans[index] = rains[i];
                        map.put(rains[i], i);
                        list.remove(lb);
                    }
                }else{
                    map.put(rains[i], i);
                } 
            }else if(rains[i] == 0){
                ans[i] = 1;
                list.add(i);
            }
        }
        return ans;
    }
    public int bs(ArrayList<Integer> list, int index){
        int low = 0, high = list.size() - 1;
        int ans = -1;
        while(low <= high){

            int mid = (low + high)/2;

            if(list.get(mid) <= index){
                low = mid + 1;
            }else if(list.get(mid) > index){
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}