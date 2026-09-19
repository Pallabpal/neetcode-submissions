class Solution {
    int maxArea = 0;
    int ct =0;
    int dir[][] = {{-1, 0}, {1,0}, {0, -1}, {0, 1}};

    void dfs(int i, int j, int[][] grid){
        
        if(i < 0 || i >= grid.length || j<0 ||
         j >= grid[0].length || grid[i][j] == 0) return;

        grid[i][j] =0;
        ct ++;

        for(int k =0; k<4; k++){

            dfs(dir[k][0]+i, dir[k][1] + j , grid);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        
        for(int i =0; i<grid.length; i++){
            for(int j =0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1){
                    ct = 0;
                    dfs(i, j, grid);

                    maxArea = Math.max(maxArea, ct);
                }
            }
        }

        return maxArea;
    }
}
