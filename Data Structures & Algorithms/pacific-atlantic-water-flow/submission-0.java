class Solution {

    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        for(int col =0 ; col<c; col++){
            dfs(0, col, pac, heights);
            dfs(r-1, col, atl , heights);
        }

         for(int row =0 ; row<r; row++){
            dfs(row, 0, pac, heights);
            dfs(row, c-1, atl , heights);
        }

       List<List<Integer>> res = new ArrayList<>();
       for(int row=0; row<r; row++){
        for(int col =0; col<c; col++){
            if(pac[row][col] && atl[row][col]){
                res.add(Arrays.asList(row, col));
            }
        }
       }
       return res;
    }

    private void dfs(int r, int c, boolean[][] ocean , int [][] heights){
        ocean[r][c] = true;
        for(int[] d: DIRS){
            int nr = r+ d[0];
            int nc = c+d[1];

            if(nr>=0 && nr< heights.length && nc>=0 && nc<heights[0].length
            && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean , heights);
            }
        }
    }
}
