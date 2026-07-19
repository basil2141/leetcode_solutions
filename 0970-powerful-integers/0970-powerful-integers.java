class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        if(x == 1 && y == 1) {
            List<Integer> temp = new ArrayList<>();
            if(bound >= 2) temp.add(2);
            return temp;
        }
        Set<Integer> set = new HashSet<>();
        int i = 0; 
        while( (int) Math.pow(x , i) + 1 <= bound){

            int j = 0;
            int sum = (int) Math.pow(x, i) + (int) Math.pow(y, j);
            while( sum <= bound){
                
                set.add(sum);
                if(y == 1) break;
                j++;
                sum = (int) Math.pow(x, i) + (int) Math.pow(y, j);
            }
            if(x == 1) break;
            i++;
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }
}