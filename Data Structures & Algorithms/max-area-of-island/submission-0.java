class Solution {

    int maxArea = 0;
    int [][]DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int dfs(int[][] grid, int r, int c, int m, int n){

        if(r<0 || r>=m || c<0 || c>=n || grid[r][c] != 1) return 0;
        grid[r][c] = 0;
        int ct = 1;
        for(int[] d: DIR){
          ct +=  dfs(grid, r+d[0], c+d[1], m, n);
        }
        return ct;
        
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 1){
                   maxArea = Math.max(maxArea, dfs(grid, i, j, m , n));
                }
            }
        }

        return maxArea;
    }
}
