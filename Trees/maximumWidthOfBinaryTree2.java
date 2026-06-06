class Solution {
    // Helper class to store a node along with its assigned heap index
    class Pair {
        TreeNode node;
        long index;
        
        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // Base case: an empty tree has a width of 0
        if (root == null) {
            return 0;
        }

        // Queue to perform standard Level-Order Traversal (BFS)
        Queue<Pair> queue = new LinkedList<>();
        
        // Start BFS by pushing the root node with a 0-based index
        queue.offer(new Pair(root, 0));
        
        int maxWidth = 0;

        // Process the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Record the index of the first (leftmost) node of the current level
            long first = queue.peek().index;
            long last = first;

            // Process all nodes belonging to the current level
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                
                // Track the current node's index (will end up as the rightmost index at the loop's end)
                long idx = current.index;
                last = idx;

                // Add left child using 0-based heap indexing formula: (2 * parent_index) + 1
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * idx + 1));
                }

                // Add right child using 0-based heap indexing formula: (2 * parent_index) + 2
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * idx + 2));
                }
            }

            // Calculate width of the completed level and update the global maximum width
            // Formula: (rightmost_index - leftmost_index) + 1
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}
