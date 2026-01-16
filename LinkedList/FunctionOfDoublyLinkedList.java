class DNode {
    int data;
    DNode next;
    DNode prev;

    DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class FunctionOfDoublyLinkedList {

    DNode head; // instance variable

    // non-static method
    public void forwardTraversal() {
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void backwardTraversal(){
        DNode curr = head;
        if(head==null){
            System.out.println("Empty DLL");
        }

        while(curr.next !=null){
            curr = curr.next;
        }
        while(curr!=null){
            System.out.print(curr.data+" <-> ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public void insertAtBeginning(int data){
        DNode newNode = new DNode(data);
        
        if(head!=null){
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        System.out.println();
    }

    public void insertAtEnd(int data){
        DNode newNode = new DNode(data);

        if(head==null){
            head = newNode;
            return;
        }

        DNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        System.out.println();
    }

    public void inserAtPosition(int data, int pos){

        if(pos<=0){
            System.out.println("Invalid position.");
        }
        if(pos==1){
            insertAtBeginning(data);
            return;
        }
        
        DNode newNode = new DNode(data);
        DNode curr = head;
        
        for(int i=1 ; i< pos-1 && curr!=null ; i++){
            curr = curr.next;
        }
        
        if(curr == null){
            System.out.print("Postion out of range.");
        }
        newNode.next=curr.next;
        newNode.prev = curr;
        
        if (curr.next != null) {
            curr.next.prev = newNode;
        }

        curr.next = newNode;
    }

    public void deleteFromBeginning(){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if(head!= null){
            head.prev = null;
        }
    }

    public void deleteFromEnd(){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
        
        if(head.next==null){
            head = null;
            return;
        }
        DNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.prev.next= null;
    }

    public void deleteFromPosition(int pos){
        if(pos <=0 || head==null){
            System.out.println("Invalid position.");
            return;
        }
        if(pos==1){
            deleteFromBeginning();
        }
        DNode curr = head;

        for(int i=1; i<pos && curr!=null; i++){
            curr = curr.next;
        }
             
        if (curr == null) {
            System.out.println("Position out of range");
            return;
        }
        
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
    }
    // Reverse DLL
public void reverse() {
    if (head == null || head.next == null) return;

    DNode curr = head;
    DNode temp = null;

    while (curr != null) {
        temp = curr.prev;
        curr.prev = curr.next;
        curr.next = temp;
        curr = curr.prev;
    }
    head = temp.prev;
}

// DLL → SLL
public void convertToSinglyLinkedList() {
    DNode curr = head;
    while (curr != null) {
        curr.prev = null;
        curr = curr.next;
    }
}


    public static void main(String[] args) {

        FunctionOfDoublyLinkedList dll = new FunctionOfDoublyLinkedList();

  dll.insertAtBeginning(3);
        dll.insertAtBeginning(2);
        dll.insertAtBeginning(1);
        dll.forwardTraversal();

        dll.insertAtEnd(4);
        dll.insertAtEnd(5);
        dll.forwardTraversal();

        dll.reverse();
        dll.forwardTraversal();

        dll.deleteFromPosition(3);
        dll.forwardTraversal();

        dll.deleteFromBeginning();
        dll.forwardTraversal();

        dll.deleteFromEnd();
        dll.forwardTraversal();

        dll.deleteFromPosition(3);
        dll.forwardTraversal();

        dll.backwardTraversal();

        dll.convertToSinglyLinkedList();
        dll.forwardTraversal();
    }
}
