class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();

        int i =0;

        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            merged.add(intervals[i++]);
        }

        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
           newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
           newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
           i++;
        }
        merged.add(newInterval);

        while(i<intervals.length){
            merged.add(intervals[i++]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}