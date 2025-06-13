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
    public ListNode rotateRight(ListNode head, int k) {
    if(k<=0 || head==null || head.next == null) return head;

    ListNode temp = head;
    int l = 1;
    while(temp.next != null){
        temp = temp.next;
        l++;
    }
    temp.next = head;
    k %= l;
    int skip = l-k;
    ListNode lastNode = head;
    for(int i=0; i<skip-1; i++)
        lastNode = lastNode.next;

    head = lastNode.next;
    lastNode.next = null;

    return head;
    }
}