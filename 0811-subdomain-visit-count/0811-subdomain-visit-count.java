class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            String s= cpdomains[i];
            String[] arr = s.split("\\s+");
            String domain = "";
            int count = Integer.parseInt(arr[0]);
            String[] arr2 = arr[1].split("\\.");
            for(int j = arr2.length-1; j>=0; j--){
                
                if(j == arr2.length-1){
                    domain = arr2[j] + domain;
                }else{
                    domain = arr2[j] + "." +domain;
                }
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
        }
        List<String> result = new ArrayList<>();
        for(String x : map.keySet()){
            String s = map.get(x) + " "+x;
            result.add(s);
        }
 
        return result;
    }
}