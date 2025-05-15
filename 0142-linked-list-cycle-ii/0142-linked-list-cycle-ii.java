/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fastptr = head;
        ListNode slowptr = head;
        ListNode temp = head;
        while(fastptr!=null && fastptr.next!=null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(fastptr==slowptr){
                while(temp !=slowptr){
                    temp = temp.next;
                    slowptr = slowptr.next;
                }
                return temp;
            }
        }
        return null;
    }
}