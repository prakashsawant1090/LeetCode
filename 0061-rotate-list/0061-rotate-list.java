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
    static int lenght(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp!=null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = lenght(head);

        // Normalize k to avoid unnecessary rotations
        k = k % len;
        if (k == 0) return head;  // No need to rotate if k is 0 after normalization

        // Step 1: Make the list circular by connecting the last node to the head
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;  // Circular link

        // Step 2: Find the new head by moving (len - k) steps from the old head
        ListNode newHead = head;
        ListNode prev = null;
        int steps = len - k;
        while (steps-- > 0) {
            prev = newHead;
            newHead = newHead.next;
        }

        // Step 3: Break the circular connection and return the new head
        prev.next = null;

        return newHead;
    }
}