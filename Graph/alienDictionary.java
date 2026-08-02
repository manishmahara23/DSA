class Solution {
    public String findOrder(String[] words) {
        int n = words.length;
        if (n == 0) return "";

        // 1. Saare unique characters dhoondo taaki 'k' pata chal sake
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                uniqueChars.add(ch);
            }
        }
        int k = uniqueChars.size(); // Yeh mil gaya hume k!

        // 2. Graph (Adjacency List) aur In-degree Map banana
        // Kyunki character 'a' se 'z' tak kuch bhi ho sakte hain, hum Map use karenge 
        // taaki sirf unhi characters ke liye space bane jo words me hain.
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Har unique character ke liye khali list aur 0 in-degree set karo
        for (char ch : uniqueChars) {
            adj.put(ch, new ArrayList<>());
            inDegree.put(ch, 0);
        }

        // 3. Consecutive words ko compare karke directed edges (rasta) banana
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            
            boolean mismatchFound = false;

            for (int j = 0; j < len; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);

                if (ch1 != ch2) {
                    adj.get(ch1).add(ch2); // ch1 -> ch2
                    inDegree.put(ch2, inDegree.get(ch2) + 1); // ch2 ki in-degree badhao
                    mismatchFound = true;
                    break; // Baaki chars check nahi karne
                }
            }

            // Edge Case: Agar mismatch nahi mila aur bada word pehle aa gaya (e.g., "abc" then "ab")
            // To yeh ek invalid dictionary hai, kyunki chhota word pehle aana chahiye.
            if (!mismatchFound && w1.length() > w2.length()) {
                return ""; // Invalid arrangement
            }
        }

        // 4. Kahn's Algorithm (BFS) - Queue me 0 in-degree wale char daalo
        Queue<Character> q = new LinkedList<>();
        for (char ch : uniqueChars) {
            if (inDegree.get(ch) == 0) {
                q.offer(ch);
            }
        }

        // 5. Queue ko process karo aur order banao
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);

            for (char neighbor : adj.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // Agar saare unique alphabets order me aa gaye to string bhejo, nahi to "" (cycle case)
        return sb.length() == k ? sb.toString() : "";
    }
}
