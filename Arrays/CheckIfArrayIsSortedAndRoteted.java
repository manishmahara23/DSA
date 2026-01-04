class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        for (int r = 0; r < n; r++) {
            int[] rot = new int[n];
            for (int i = 0; i < n; i++) {
                rot[i] = nums[(i + r) % n];
            }

            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (rot[i] > rot[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) return true;
        }
        return false;
    }
}
