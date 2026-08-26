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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
        
        ListNode left = list1;
        ListNode right = list2;

        while(left != null && right!= null){
            if(left.val > right.val){
                dummy.next = right;
                dummy = dummy.next;
                right = right.next;
            }
            else{
                dummy.next = left;
                dummy = dummy.next;
                left = left.next;
            }
        }

        while(right!=null){
             dummy.next = right;
             dummy = dummy.next;
             right = right.next;
            
        }

        while(left!=null){
             dummy.next = left;
             dummy = dummy.next;
             left = left.next;
            
        }

        return ans.next;

    }
}