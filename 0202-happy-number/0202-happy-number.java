class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while(fast!=1 && fast!=slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast==1;
    }
    public static int getNext(int n){
        int sum=0;
        while(n>0){
            int r = n%10;
            sum += r*r;
            n /=10;
        }
        return sum;
    }
}