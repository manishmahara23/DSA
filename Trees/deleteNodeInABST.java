class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 1. Navigate the tree to find the node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node! Handle the 3 deletion cases:
            
            // Case 1 & 2: No children or only 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            // Case 3: Two children
            // Find the minimum value node in the right subtree (Inorder Successor)
            TreeNode minNode = findMin(root.right);
            // Replace current node's value with successor's value
            root.val = minNode.val;
            // Delete the successor node from the right subtree
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
