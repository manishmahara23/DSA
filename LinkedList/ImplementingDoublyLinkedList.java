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

public class ImplementingDoublyLinkedList {
    public static void main(String[] args) {

        DNode head = new DNode(10);
        DNode a = new DNode(20);
        DNode b = new DNode(30);
        DNode c = new DNode(40);
        DNode d = new DNode(50);

        // Linking nodes properly
        head.next = a;
        a.prev = head;

        a.next = b;
        b.prev = a;

        b.next = c;
        c.prev = b;

        c.next = d;
        d.prev = c;

        // Forward traversal
        System.out.print("Forward Traversal: ");
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        // Backward traversal
        System.out.print("Backward Traversal: ");
        DNode tail = d;
        while (tail != null) {
            System.out.print(tail.data + " -> ");
            tail = tail.prev;
        }
        System.out.println("null");
    }
}
