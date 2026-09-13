/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {

        Queue<Node> q = new LinkedList<>();
        
        if(root == null) return root;
        q.offer(root);

        while(!q.isEmpty()){
            int sz = q.size();

            for(int i =0; i<sz;i++){
                Node top = q.poll();
                if(i<sz-1){
                 top.next = q.peek();
                }else{
                    top.next = null;
                }
               
                if(top.left != null){
                    q.offer(top.left);
                }
                if(top.right != null){
                    q.offer(top.right);
                }

            }
        }
        return root;
        
    }
}