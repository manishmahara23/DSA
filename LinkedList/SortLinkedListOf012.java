class Solution {
    public Node segregate(Node head) {
        
        int count0 = 0, count1=0, count2=0;
        
        Node curr = head;
        
        while(curr!=null){
            if(curr.data==0)count0++;
            else if(curr.data==1)count1++;
            else count2++;
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr!=null){
            if(count0>0){
                curr.data = 0;
                count0--;
            }else if(count1>0){
                curr.data = 1;
                count1--;
            }else{
                curr.data =2;
                count2--;
            }
            curr = curr.next;
        }
        return head;
    }
}