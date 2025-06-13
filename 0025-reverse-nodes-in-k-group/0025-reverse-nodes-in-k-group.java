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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null){
            return head;
        }

        ListNode current = head, prev = null;

        while(true){
            ListNode lastNodeOfPreviousPart = prev;
            ListNode lastNodeOfSublist = current;

            ListNode temp = current;
            int x=0;
            while(temp!=null){
                temp = temp.next;
                x++;
            }
            if(x<k) break;

            ListNode next = null;
            for(int i=0; current!=null && i<k; i++){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            if(lastNodeOfPreviousPart!=null){
                lastNodeOfPreviousPart.next = prev;
            }else{
                head = prev;
            }
            lastNodeOfSublist.next = current;
            prev= lastNodeOfSublist;
        }
        return head;
    }
}