class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first  = head;
        ListNode second = head.next;

        first.next  = swapPairs(second.next); // recurse on rest
        second.next = first;                  // swap

        return second;
    }
}