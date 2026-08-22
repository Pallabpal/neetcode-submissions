/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    ListNode reverse(ListNode prev, ListNode node){
        if(node.next == null){
            node.next = prev;
            return node;
        }
        ListNode newNode = reverse(node, node.next);
        node.next = prev;
        return newNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1 = l1;
        ListNode node2 = l2;

        int carry =0;
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        while(node1 != null || node2 != null || carry != 0){

            int a = node1 !=null ?  node1.val : 0;
            int b = node2 != null ? node2.val : 0;

            int sum = a+b+carry;
            carry = sum /10;
            sum = sum %10;
            ListNode tempNode = new ListNode(sum, null);
            dummy.next = tempNode;
            dummy =tempNode;
            
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null; 
        }

        return ans.next;
        
    }
}

