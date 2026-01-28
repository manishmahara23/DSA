class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    private Node top;

    public Stack(){
        top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }

    public void push(int x){
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        Node curr = top;
        while(curr!=null){
            System.out.print(curr.data +" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
public class ImplementingStackUsingLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(100);
        stack.push(200);
        stack.push(300);

        stack.display();

        System.out.println(stack.pop());  
        System.out.println(stack.peek()); 

        stack.display();
    }
}
