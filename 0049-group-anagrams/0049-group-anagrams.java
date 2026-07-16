class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0; i<n; i++){
            Map<Character, Integer> freq = freqMap(strs[i]);
            if(map.containsKey(freq)){
                map.get(freq).add(strs[i]);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(freq, temp);
            }
        } 

        List<List<String>> result= new ArrayList<>();

        for(Map<Character, Integer> f : map.keySet()){
            result.add(map.get(f));
        }  
        return result;
    }
    public Map<Character, Integer> freqMap(String s){
        Map<Character, Integer> map  = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}