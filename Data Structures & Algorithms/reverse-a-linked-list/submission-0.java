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
      ListNode curr =  reverse(node, node.next);
      node.next = prev;
      return curr;


    }
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return head;

        ListNode node = reverse(null, head);

        return node;

    }
}
