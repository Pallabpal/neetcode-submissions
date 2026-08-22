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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) return head;

        ListNode slow = new ListNode(-1, head);
        ListNode fast = head;
        int i = 1;
        while(i<n){
            fast = fast.next;
            i++;
        } 
        ListNode temp = null; 
        while(fast != null){
            fast = fast.next;
            temp= slow;
            slow = slow.next;
           
        }

        temp.next = slow.next;
        if(temp.val == -1){
            head = slow.next;
        };
        return head;

    }
}
