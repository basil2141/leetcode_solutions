import java.util.HashMap;
class Solution {
    public int totalFruit(int[] fruits) {
        int l=Integer.MIN_VALUE, left=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right=0; right<fruits.length; right++){
            
            map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
            while(map.size()>2){
                map.put(fruits[left], map.getOrDefault(fruits[left],0)-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            l = Math.max(l, right-left+1);
        }
        return l;
    }
}