class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;           // 1st node
        ListNode even = head.next;     // 2nd node
        ListNode evenHead = even;      // head of even list

        while (even != null && even.next != null) {
            odd.next = even.next;      // link odd nodes
            odd = odd.next;

            even.next = odd.next;      // link even nodes
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;
    }
}
