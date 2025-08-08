class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> result = new ArrayList<>();

      dfs(s, 0, new ArrayList<>(), result);
      return result;       
    }
    public void dfs(String s, int start, List<String> curr, List<List<String>> result){
        if(start >= s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++){

            if(isPalin(s, start, end)){
                curr.add(s.substring(start, end + 1));
                dfs(s, end + 1, curr, result);
                curr.remove(curr.size()-1);
            }
            
        }
    }
    public boolean isPalin(String s , int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}