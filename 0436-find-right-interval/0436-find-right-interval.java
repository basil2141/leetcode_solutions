class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        int  n = intervals.length;

        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2)-> intervals[i2][0]- intervals[i1][0]);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2)-> intervals[i2][1] - intervals[i1][1]);

        for(int i=0; i<n; i++){
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        for(int i=0; i<n; i++){
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;

            if(intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]){

                 int topStart = maxStartHeap.poll();
                // finding nearest start
                while(!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]){
                topStart = maxStartHeap.poll();
            }

            result[topEnd] = topStart;
            maxStartHeap.offer(topStart);
            }
            
        }
        return result;
    }
}