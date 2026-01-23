class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0) return head;

        // find new tail
        ListNode curr = head;
        int length = 1;
        while(curr.next!=null){
            curr = curr.next;
            length++;
        }

        // make a circular linked list
        curr.next = head;

        // find effective iterations
        k = k% length;

        int stepsToNewTail = length -k-1;

        ListNode newTail = head;

        for(int i=0; i<stepsToNewTail; i++){
            newTail = newTail.next;
        }

        // break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}