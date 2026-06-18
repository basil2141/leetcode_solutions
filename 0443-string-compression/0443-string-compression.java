class Solution {
    public int compress(char[] chars) {
        String s = "";

        int n = chars.length;
        int i = 0;
        while(i < n){
            char c= chars[i];
                s += c;
                int j = i;
                while(i +1 < n && chars[i +1] == chars[j]){
                    i++;
                }
                if(i -j + 1 > 1) s += (i-j + 1);
                i++;
        }
        for(i = 0; i<s.length(); i++) chars[i] = s.charAt(i);
        return s.length();
    }
}