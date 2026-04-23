class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = 1;

        for(int i = 0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(c == 'D'){
                st.push(num); num++;
            }else{
                st.push(num); num++;

                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }
        st.push(num);
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}