class Solution {
    Node removeDuplicates(Node head) {

        if (head == null) return head;

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {

                Node dup = curr.next;
                curr.next = dup.next;

                if (dup.next != null) {
                    dup.next.prev = curr;
                }
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }
}
