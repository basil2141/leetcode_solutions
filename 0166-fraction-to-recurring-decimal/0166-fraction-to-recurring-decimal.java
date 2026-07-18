class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();

        if( (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) ans.append("-");

        long n = (long) Math.abs( (long) numerator);
        long d = (long) Math.abs( (long) denominator);

        long q =  n/d;  
        ans.append(q);
        long r = n%d;
        if(r == 0){
            return ans.toString();
        }    
        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        
        while(r != 0){
            if(map.containsKey(r)){
                int index = map.get(r);
                ans.insert(index, "(");
                ans.append(")");
                return ans.toString();
            }else{
            map.put(r, ans.length());    
            r = r*10;
            q = r/d;
            ans.append(q);
            r = r%d;
            } 
        } 
        return ans.toString();   
    }
}