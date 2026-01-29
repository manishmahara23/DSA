class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (open > 0) ans.append(c);
                open++;
            } else {
                open--;
                if (open > 0) ans.append(c);
            }
        }
        return ans.toString();
    }
}
