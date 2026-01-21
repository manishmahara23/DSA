class Solution {
    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public Node addOne(Node head) {
        
        head = reverse(head);
        
        Node curr = head;
        int carry = 1;
        
        while(curr!=null && carry>0){
            int sum = curr.data + carry;
            
            curr.data = sum%10;
            carry = sum/10;
            
            if(curr.next==null && carry>0){
                curr.next = new Node(carry);
                carry = 0;
            }
            curr = curr.next;
        }
        return reverse(head);
    }
}