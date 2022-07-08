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
    public ListNode middleNode(ListNode head) {
        
        ListNode nextPtr = head.next;
        ListNode next_NextPtr = null;
        if(nextPtr != null) {
            next_NextPtr = nextPtr.next;
        }
        while(next_NextPtr != null) {
            if(next_NextPtr.next != null) {
                nextPtr = nextPtr.next;
                next_NextPtr = next_NextPtr.next;
                if(next_NextPtr != null) {
                    next_NextPtr = next_NextPtr.next;
                }
            }else {
                break;
            }
        }
        return nextPtr != null ? nextPtr : head;
    }
}