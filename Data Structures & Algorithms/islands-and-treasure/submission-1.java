class Solution {
    
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int INF = 2147483647;

    public int dfs(int[][] grid, int r, int c, int m , int n, boolean [][] visited){
        if(r<0 || r>=m || c<0 || c>=n || visited[r][c] || grid[r][c] == -1) 
        return INF;
        if(grid[r][c] == 0) return 0;
        visited[r][c] = true;
        
        int res = INF;
        for(int[]  d: DIRS){
            int curr = dfs(grid, r+ d[0], c+d[1], m, n, visited);
            if(curr != INF){
            res = Math.min(res, 1+curr);
            }
        }
        visited[r][c] = false;
        return res;

    }

    public void islandsAndTreasure(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean [][]visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i<m ; i++ ){
            for(int j =0; j<n; j++){
                if(grid[i][j] == 0){
                   q.offer(new int[]{i, j});
                }
            }
        }

        if(q.size() == 0) return ;

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int i =0; i<4; i++){
             int row = DIRS[i][0] + r;
             int col = DIRS[i][1] + c;   
             if(row<0 || row>=m || col<0 || col>=n||grid[row][col] != Integer.MAX_VALUE)
                continue;
                
                q.add(new int[]{row,col});
                grid[row][col] = grid[r][c] + 1; 
        
            }
        }
    }
}
