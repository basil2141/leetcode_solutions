class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<Parentheses> q = new LinkedList<>();
        q.add(new Parentheses("",0,0));

        while(!q.isEmpty()){
            Parentheses p = q.poll();

            if(p.openC == n && p.closeC == n) result.add(p.str);
            else{
                if(p.openC < n) q.add(new Parentheses(p.str + "(", p.openC + 1, p.closeC));
                
                if(p.closeC < p.openC) q.add(new Parentheses(p.str + ")", p.openC, p.closeC + 1));
            }
        } 
        return result;
    }
}
class Parentheses{
    String str;
    int openC;
    int closeC;

    public Parentheses(String str, int openC, int closeC){
        this.str = str;
        this.openC = openC;
        this.closeC = closeC;
    }
}