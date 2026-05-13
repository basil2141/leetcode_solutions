class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int minr = 0, minc = 0, maxr = grid.length-1, maxc= grid[0].length-1;
        int m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];

        while(minr < maxr && minc < maxc){
            int lw = 2*(maxr - minr + 1);
            int tw = 2*(maxc - minc + 1);

            int size = lw + tw - 4;
            int[] arr = oneDFromShell(grid, minr, minc, maxr, maxc);
            rotate(arr, k);
            fromOneD(result,arr, minr, minc, maxr, maxc);
            minr++; minc++;
            maxr--; maxc--;
        }
        return result;
    }
    public void rotate(int[] arr, int k){
    
        int n = arr.length;
        k = k%n;
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);
    }
    public void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public void fromOneD(int[][] result, int[] arr, int minr, int minc, int maxr, int maxc){
        
        int idx = 0;
        //lw
        for(int i = minr, j = minc; i<=maxr; i++){
            result[i][j] = arr[idx];
            idx++;
        }
        //bw
        for(int i = maxr, j = minc + 1; j<=maxc; j++){
            result[i][j] = arr[idx];
            idx++;
        }
        //rw
        for(int i = maxr-1, j = maxc; i>=minr; i--){
            result[i][j] = arr[idx];
            idx++;
        }
        //tw
        for(int i = minr, j = maxc-1; j>=minc+1; j--){
            result[i][j] = arr[idx];
            idx++;
        }
    }
    public int[] oneDFromShell(int[][] grid, int minr, int minc, int maxr, int maxc){
        int size = 2*(maxr - minr + maxc - minc);
        int[] arr = new int[size];
        int idx = 0;
        //lw
        for(int i = minr, j = minc; i<=maxr; i++){
            arr[idx] = grid[i][j];
            idx++;
        }
        //bw

        for(int i = maxr, j = minc + 1; j<=maxc; j++){
            arr[idx] = grid[i][j];
            idx++;
        }
        //rw

        for(int i = maxr-1, j = maxc; i>=minr; i--){
            arr[idx] = grid[i][j];
            idx++;
        }

        //tw
        for(int i = minr, j = maxc-1; j>=minc+1; j--){
            arr[idx] = grid[i][j];
            idx++;
        }
        return arr;
    }
}