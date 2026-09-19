class Solution {
    public int[][] generateMatrix(int n) {
        int top =0;
        int left = 0; 
        int right = n-1;
        int bottom = n-1;
        int num = 1;
        int[][] matrix = new int[n][n];
        int j;
        while(top<= bottom && left <=right){
             
            for(j = left ; j<=right; j++){
                matrix[top][j] = num ++;
            }
            top ++;
            
            for(j = top ; j<= bottom ; j++){
                matrix[j][right] = num ++;
            }

            right --;
            if(top <= bottom){
            for(j = right ; j >= left ; j --)
              matrix[bottom][j] = num ++;
            }
            bottom --;

            if(left <= right)
            for(j = bottom ; j>=top ; j--){
                matrix[j][left] = num ++; 
            }
            left ++;
        }

        return matrix;
    }
}