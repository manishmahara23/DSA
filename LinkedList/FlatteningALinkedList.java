class Solution {
    Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the next list
        root.next = flatten(root.next);

        // Merge current list with flattened next list
        root = merge(root, root.next);

        return root;
    }

    private Node merge(Node a, Node b) {
        // If one list is empty
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // IMPORTANT
        return result;
    }
}