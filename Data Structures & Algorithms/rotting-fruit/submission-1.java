class Solution {

    public static int[][] DIRS = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {

     int n = grid.length;
     int m = grid[0].length;

     Queue<int[]> q = new LinkedList<>();

     for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(grid[i][j] == 2){
                q.offer(new int[]{i,j});
            }
        }
     }

     int time = 0;
     while(!q.isEmpty()){
        boolean isProcessed = false;
        int sz = q.size();
        for(int i =0; i<sz; i++){

        int[] ele = q.poll();
        int r = ele[0];
        int c= ele[1];

       for(int[] d : DIRS){
          int nr = d[0] + r;
          int nc = d[1] + c;

          if(nr<0 || nr>=n || nc<0 || nc>=m || grid[nr][nc]!=1) 
             continue;
          isProcessed = true;
          grid[nr][nc] = 2;
          q.offer(new int[]{nr, nc});   

       }
        }

       if(isProcessed) {
        time ++;
       }

     }

     for(int i =0; i<n; i++){
        for(int j=0; j<m; j++){
            if(grid[i][j] ==1){
              return -1;
            }
        }
     }

     return time;

    }
}
