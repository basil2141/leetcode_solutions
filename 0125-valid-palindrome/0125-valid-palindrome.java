class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)) str.append(Character.toLowerCase(c));
        }
        char[] arr = str.toString().toCharArray();
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            if(arr[start]!=arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}