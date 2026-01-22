class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node curr = head;

        while (curr != null) {
            if (curr.data == x) {
                // If node to be deleted is head
                if (curr.prev == null) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                // If node to be deleted is not head
                else {
                    curr.prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
