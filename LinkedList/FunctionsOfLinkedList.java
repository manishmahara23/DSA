class Node{
    int data;
    Node next;

    Node(int new_data){
        this.data = new_data;
        this.next = null;
    }
}

public class FunctionsOfLinkedList {
    
    Node head;

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println();
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println();
    }

    public void insertAtPosition(int data, int position){
        if(position<0){
            System.out.print("Invalid position!");
            return;
        }

        Node newNode = new Node(data);

        if(position==0){
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node temp = head;

        for(int i=0; i<position-1; i++){
            if(temp==null){
                System.out.print("Position out of range.");
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
        System.out.println("Position out of range.");
        return;
    }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println();
    }

public void deleteFromBeginning() {

    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    head = head.next;
    System.out.println();
}
    public void deleteFromEnd(){
        if(head==null){
            System.out.print("LL is Empty.");
            return;
        }
        
        // only one node
        if(head.next == null){
            head = null;
            return;
        }

        //move to second last node;
        Node curr = head;
        while(curr.next.next==null){
            curr = curr.next; 
        }
        curr.next = null;
        System.out.println();
    }

    public void delectFormposition(int pos){
        if(head==null || pos<1){
            System.out.print("Invalid operation.");
            return;
        }

        if (pos==1){
            head = head.next;
            return;
        }

        Node curr = head;

        for(int i=0; i<=pos-2; i++){
            if(curr.next==null){
                System.out.println("Position out of range.");
                return;
            }
            curr = curr.next;
        }
        curr.next= curr.next.next;
        System.out.println();
    }

    public boolean search(int key){
        Node curr = head;
        while(curr!=null){
            if(curr.data ==key){
                return true;   
            }
            curr = curr.next;
        }
        return false;
    }
    public void deleteByValue(int key){
        if(head== null){
            return;
        }

        // if head is to be deleted
        if(head.data == key){
            head= head.next;
            return;
        }
        Node curr = head;
        while(curr.next!=null && curr.next.data !=key){
            curr = curr.next;
        }
        if(curr.next== null){
            System.out.print("Value not found.");
            return;
        }
        curr.next = curr.next.next;
        System.out.println();
    }

    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr!=null){
            next = curr.next;   // store next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev
            curr = next;        // move curr
        }
        head = prev;
        System.out.println();
    }
    
public static void main(String[] args) {
    FunctionsOfLinkedList LL = new FunctionsOfLinkedList();

        LL.insertAtEnd(10);
        LL.display();
        // LL.insertAtEnd(20);
        LL.display();
        LL.insertAtBeginning(5);
        
        LL.display();
        LL.insertAtPosition(15, 2);
        LL.display();
        // LL.insertAtEnd(30);
        LL.display();
        LL.insertAtPosition(25, 3);
        LL.display();
        LL.insertAtPosition(35, 4);
        LL.display();
        LL.insertAtPosition(40, 5);
        LL.display();
        LL.deleteFromBeginning();
        LL.display();
        LL.reverse();
        LL.display();
}
}
