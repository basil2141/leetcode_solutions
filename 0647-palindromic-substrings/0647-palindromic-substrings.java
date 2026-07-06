class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] palin = new boolean[n][n];
        int count = 0; 
        for(int gap =0; gap<n; gap++){
            for(int i = 0, j = gap; j<n; i++, j++){
                if(gap == 0){
                    palin[i][j] = true;
                    if(palin[i][j]) count++;
                }else if(gap == 1){
                    palin[i][j] = (s.charAt(i) == s.charAt(j));
                    if(palin[i][j]) count++;

                }else{
                    palin[i][j] = (s.charAt(i) == s.charAt(j)) && palin[i + 1][j-1];
                    if(palin[i][j]) count++;
                }
            }
        }
        return count;
    }
}