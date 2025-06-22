class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        PriorityQueue<Integer> min = new PriorityQueue<>(n,(a,b)-> capital[a] - capital[b]);
        PriorityQueue<Integer> max = new PriorityQueue<>(n, (a,b)-> profits[b] - profits[a]);

        for(int i=0; i<n; i++) min.offer(i);

        int available = w;
        for(int i=0; i<k; i++){

            while(!min.isEmpty() && capital[min.peek()] <= available) max.offer(min.poll());

            if(max.isEmpty()) break;

            available += profits[max.poll()];
        }

        return available;
    }
}