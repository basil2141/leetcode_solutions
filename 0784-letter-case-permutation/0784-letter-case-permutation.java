class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if(s == null) return result;

        result.add(s);

        for(int i=0; i<s.length(); i++){
            // only process if not digit

            if(Character.isLetter(s.charAt(i))){

                int n = result.size();

                // for each particular subset I need to change case

                for(int j=0; j<n; j++){
                    //get the subset

                    char[] c = result.get(j).toCharArray();

                    if(Character.isUpperCase(c[i])) c[i] = Character.toLowerCase(c[i]);
                    else c[i] = Character.toUpperCase(c[i]);

                    result.add(String.valueOf(c));
                }
            }
        
        }
            return result;
    }
}