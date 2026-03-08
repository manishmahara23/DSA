class Solution {
    private ListNode front;

    public boolean isPalindrome(ListNode head) {
        front = head;
        return check(head);
    }

    private boolean check(ListNode node) {
        if (node == null) return true;

        if (!check(node.next)) return false;

        if (node.val != front.val) return false;

        front = front.next;
        return true;
    }
}