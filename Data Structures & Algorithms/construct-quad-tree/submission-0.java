/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    boolean isSameValue(int[][] grid, int i, int j, int length){
        for(int k =i; k<i+length; k++){
            for(int l =j; l<j+length ; l++){
                if(grid[k][l] != grid[i][j] ) return false;
            }

        }

        return true;
    }

    public Node Solve(int[][] grid, int i, int j, int length){
        if(isSameValue(grid, i, j, length)){
            return new Node( grid[i][j] == 1? true : false, true, null, null, null, null);
        }
        
        Node newNode = new Node(false, false, null, null, null, null);
        newNode.topLeft      = Solve(grid, i, j, length/2);
        newNode.topRight     = Solve(grid, i, j + length/2, length/2);
        newNode.bottomLeft   = Solve(grid, i + length/2, j, length/2);
        newNode.bottomRight  = Solve(grid, i+length/2, j+ length/2, length/2);

        return newNode;

    }
    public Node construct(int[][] grid) {
        return Solve(grid, 0, 0, grid.length);
    }
}