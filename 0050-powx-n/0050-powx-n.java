class Solution {
    public double myPow(double x, int n) {
 
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = power(x, N);
        return ans;
    }
    public double power(double x, long n){
        if(n == 0){
            return (double)1;
        }

        if(n%2 == 1){
            double temp = power(x, (n-1)/2);
            return x*temp*temp;
        }else{
            double temp = power(x, n/2);
            return temp*temp;
        }
    }
}