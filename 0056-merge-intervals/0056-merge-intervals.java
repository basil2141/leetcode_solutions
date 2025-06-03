import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];
        merged.add(current);

        for(int[] interval : intervals){
            int currentEnd = current[1];
            int nextEnd = interval[1];
            int nextStart = interval[0];

            if(nextStart<=currentEnd){
                current[1] = Math.max(currentEnd, nextEnd);
            }
            else{
                current = interval;
                merged.add(interval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}