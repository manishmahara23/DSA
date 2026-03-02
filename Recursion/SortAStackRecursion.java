class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        // base case 
        if(st.isEmpty()) return;
        
        // remove top element 
        int top = st.pop();
        
        // sort rest of the stack
        sortStack(st);
        
        // insert top at correct position
        insert(st,top);
    }
    
    public void insert(Stack<Integer> st, int value){
        
        // base case 
        if(st.isEmpty() || st.peek()<=value){
            st.push(value);
            return;
        }
        
        // Remove top and recursion
        int top = st.pop();
        insert(st, value);
        
        // push back removed element 
        st.push(top);
      }
    }