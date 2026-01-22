class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(
            Node head, int target) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (head == null) return res;

        Node left = head;
        Node right = head;

        // Move right to last node
        while (right.next != null) {
            right = right.next;
        }

        while (left != right && left.prev != right) {
            int sum = left.data + right.data;

            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                res.add(pair);

                left = left.next;
                right = right.prev;
            }
            else if (sum < target) {
                left = left.next;
            }
            else {
                right = right.prev;
            }
        }

        return res;
    }
}
