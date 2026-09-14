/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

   int count =0;
    void Solve(TreeNode root, int maxSofar){
        
        if(root == null){
         return;
        }

        if(root.val >= maxSofar){
         count ++;
         maxSofar = root.val;
        }

      //   System.out.println(root.val +" " + maxSofar);

        Solve(root.left, maxSofar);
        Solve(root.right, maxSofar);
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
         Solve(root, root.val);
         return count;
    }
}
