class Solution {
    public int minSteps(int n) {
        boolean isprime = isPrime(n);
        int result = 0;
        int x = n;
        if(!isprime){
            for(int i = 2; i<= x/2; i++){
                while(n%i == 0){
                    result = result + i;
                    n /= i;
                }
            }
        }else{
            return n;
        }
        return result;
    }
    public boolean isPrime(int n){
        if(n == 1) return false;
        for(int i =2; i<= Math.pow(n, 0.5); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}