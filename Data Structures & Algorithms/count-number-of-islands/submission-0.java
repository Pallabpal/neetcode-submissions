class Solution {

    int [][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0 , 1}};

    public void dfs(char[][] grid, int r, int c, int m ,int n){
        if(r < 0 || r >= m || c < 0  || c >=n || grid[r][c] != '1') return;

        grid[r][c] = '0';
        for(int[] d : DIRS){
            dfs(grid, d[0]+r, d[1]+c, m, n);
        }
    }
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j] == '1'){
                dfs(grid, i, j, m, n);
                count ++;
                }
            }
        }
        return count;
    }
}
