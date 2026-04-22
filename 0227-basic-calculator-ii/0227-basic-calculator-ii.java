class Solution {
    public int calculate(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        String st = s;
        int n = st.length();
        int i = 0;
        while(i < n){
            char c= st.charAt(i);

            if(Character.isDigit(c)){
                int num = 0;
                while(i < n && Character.isDigit(st.charAt(i))){
                    num = num * 10 + (st.charAt(i) - '0');
                    i++;
                }
                st1.push(num);
                continue;
            } else if(c == '+' || c=='-' || c=='*' || c=='/'){
                int pre = precedence(c);
                while(!st2.isEmpty() && st2.peek() != '(' && (precedence(st2.peek() )>= pre)) evaluate(st1, st2);
                    st2.push(c);
            }else if(c == '(') st2.push(c);
            else if(c == ')'){
                while(!st2.isEmpty() && st2.peek() != '(') evaluate(st1, st2);
                st2.pop();
            }
            i++;
        }

        while(!st2.isEmpty()){
            evaluate(st1,st2);
        }
        return st1.peek();
    }
    public int precedence(char c){
        if(c == '+' || c=='-') return 1;
        return 2;
    }
    public void evaluate(Stack<Integer> st1, Stack<Character> st2){

        int a = st1.pop();
        int b = st1.pop();
        char c = st2.pop();

        if(c == '-'){
            st1.push(b-a);
        }else if(c == '+'){
            st1.push(b + a);
        }else if(c == '*'){
            st1.push(b * a);
        }else if(c == '/'){
            st1.push(b / a);
        }
    }
}