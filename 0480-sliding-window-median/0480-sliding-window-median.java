class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k+1];

        TreeSet<Integer> left = new TreeSet<>((a,b)->{
        if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
        return Integer.compare(a,b);}
        );

        TreeSet<Integer> right = new TreeSet<>((a,b)->{
        if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
        return Integer.compare(a,b);}
        );

        for(int i=0; i<k; i++) add(i, left, right, nums, k);
        
        result[0] = getMedian(left, right, nums, k);

        for(int i=k; i<nums.length; i++){
            int toRemove = i-k;

            if(!left.remove(toRemove)) right.remove(toRemove);

            add(i, left, right, nums,k);

            result[i-k+1] = getMedian(left, right, nums, k);
        }

        return result;
    }
    public void add(int index, TreeSet<Integer> left, TreeSet<Integer> right, int[] nums, int k){
        right.add(index);
        
        // balance
        left.add(right.pollFirst());

        while(left.size()>k/2) right.add(left.pollLast());   
    }
    public double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums, int k){
        
                if (k % 2 == 1) {
            return (double) nums[right.first()];
        } else {
            return ((double) nums[left.last()] + (double)nums[right.first()]) / 2.0;

    }
}
}