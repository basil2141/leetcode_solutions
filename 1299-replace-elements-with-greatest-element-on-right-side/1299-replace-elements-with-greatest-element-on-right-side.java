class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int right_max = -1;

        for(int i=n-1; i>=0; i--){
            int temp = arr[i];
            result[i] = right_max;
            right_max = Math.max(temp, right_max);
        }
        return result;
    }
}