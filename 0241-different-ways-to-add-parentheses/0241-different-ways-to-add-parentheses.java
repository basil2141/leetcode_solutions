class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if(!expression.contains("+") && !expression.contains("-") && !expression.contains("*")){
            result.add(Integer.parseInt(expression));
        }else{
            for(int i=0; i<expression.length(); i++){
                char ch = expression.charAt(i);
                if(!Character.isDigit(ch)){
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for(int num1 : left){
                        for(int num2 : right) {
                            if(ch == '+') result.add(num1 + num2);
                            if(ch == '-') result.add(num1 - num2);
                            if(ch == '*') result.add(num1 * num2);
                        }
                    }
                }
            }
        }
        return result;
    }
}