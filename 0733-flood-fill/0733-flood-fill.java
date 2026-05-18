class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int[][] result = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                result[i][j] = image[i][j];
            }
        }

        int prev = image[sr][sc];
        recursion(result, sr, sc, color, prev, visited);
        return result;
    }
    public void recursion(int[][] result, int r, int c, int color, int prev, boolean[][] visited){
        int m = result.length, n = result[0].length;

        if(r<0 || r>=m || c<0 || c>=n || result[r][c] != prev || visited[r][c]){
            return;
        }
        result[r][c] = color;
        visited[r][c] = true;
        // up then right then down then left
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int[] dir : dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            recursion(result, nr, nc, color, prev, visited);
        }
    }
}