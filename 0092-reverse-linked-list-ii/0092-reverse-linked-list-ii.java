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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;

        for(int i = 1; i<left; i++){
            p1 = p1.next;
        }

        ListNode curr = p1.next;
        ListNode tail = p1.next;
        ListNode next = null;
        ListNode prev = null;

        for(int i= left; i<=right; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        p1.next = prev;
        tail.next = curr;

        return dummy.next;
    }
}