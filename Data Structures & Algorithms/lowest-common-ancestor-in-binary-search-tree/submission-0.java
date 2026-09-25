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

    TreeNode Solve(TreeNode root, TreeNode p, TreeNode q){

        if(root == null){
            return root;
        }

        if(root == p || root == q){
           return root;
        }

        TreeNode left = Solve(root.left , p, q);
        TreeNode right = Solve(root.right, p, q);

        if(left != null  && right != null){
            return root;
        }

        return left != null ? left : right !=null ? right : null; 
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return Solve(root, p, q);
    }
}
