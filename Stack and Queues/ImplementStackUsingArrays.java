class Stack{
    private int[] arr;
    private int maxSize;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        this.arr = new int[maxSize];
        this.top = -1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("Stack OverFlow");
            return;
        }
        arr[++top] = x;
    }
    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack Is Empty.");
            return;
        }
        for(int i = top; i>=0 ; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class ImplementStackUsingArrays {
    public static void main(String[] args) {
    Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();   // 30 20 10

        System.out.println(stack.pop());   // 30
        System.out.println(stack.peek());  // 20

        stack.display();  
    }
}
