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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry=0, sum=0, total =0;
        while(l1!=null || l2!=null){
            int a = l1!=null ? l1.val:0;
            int b = l2!=null ? l2.val: 0;
            
            total = a+b+carry;
            sum = total%10;
            carry = total/10;

            dummy.next = new ListNode(sum);
            dummy = dummy.next;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry>0){
            dummy.next = new ListNode(carry);
        }
        return head.next;
    }
}