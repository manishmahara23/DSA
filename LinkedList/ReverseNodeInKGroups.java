class Solution {
    private ListNode getKthNode(ListNode start, int k){
        while(start!=null && k>0){
            start = start.next;
            k--;
        }
        return start;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true){
            // find the k-th node
            ListNode kth = getKthNode(prevGroup,k);
            if(kth==null) break;

            ListNode nextGroup = kth.next;

            // reverse the group
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;

            while(curr!=nextGroup){
                ListNode temp = curr.next;
                curr.next = prev;

                prev = curr;
                curr = temp;
            }
            // reconnect
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        } 
        return dummy.next;
    }
}