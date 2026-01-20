class Solution {

    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // 1) Split the list into two halves
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // 2) Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3) Merge sorted halves
        return merge(left, right);
    }

    // Find middle of list
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
