class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int i = 0, n = s.length();

        while (i < n) {
            while (i < n && s.charAt(i) == ' ') i++; // skip spaces
            if (i >= n) break;

            int j = i;
            while (j < n && s.charAt(j) != ' ') j++; // word end
            words.add(s.substring(i, j));
            i = j;
        }

        Collections.reverse(words);

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < words.size(); k++) {
            sb.append(words.get(k));
            if (k != words.size() - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
