class Solution {
    
    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }

    private static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }
}
