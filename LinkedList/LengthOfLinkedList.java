
class Solution {
    public int getCount(Node head) {
        int count =0;
        
        if(head==null) return 0;
        Node temp = head;
        
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}