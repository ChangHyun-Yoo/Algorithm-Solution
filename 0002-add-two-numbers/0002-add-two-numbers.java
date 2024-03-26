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
        ListNode answer = new ListNode();
        ListNode current = answer;
        
        int val = 0;
        while(true) {
            int i = l1.val + l2.val + val;
            
            if(i >= 10) {
                val = 1;
                current.val = i % 10;
            } else {
                val = 0;
                current.val = i;
            }
            
            
            if(l1.next == null && l2.next == null) {
                if(val == 1) current.next = new ListNode(1);
                break;
            } else if(l1.next == null && l2.next != null) {
                l1.val = 0;
                l2 = l2.next;
            } else if(l1.next != null && l2.next == null) {
                l2.val = 0;
                l1 = l1.next;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
            current.next = new ListNode();
            current = current.next;
        }
        
        return answer;
    }
}