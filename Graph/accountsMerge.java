class Solution {
    // Ultimate Boss (Root Parent) dhoondhne ka function
    private int find(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }
        // Path Compression: Rasta chota karne ke liye
        return parent[node] = find(parent[node], parent);
    }

    // Dono groups ko aapas mai jodne ka function (Provinces jaisa boolean trick)
    private boolean union(int u, int v, int[] parent) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU != rootV) {
            parent[rootU] = rootV; // Kisi ek ko boss bana diya
            return true; 
        }
        return false; 
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];

        // Shuru mai har account khud ka boss hai
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Map: Email -> Account Index (ID)
        Map<String, Integer> emailToId = new HashMap<>();

        // Step 1: Emails scan karo aur aapas mai Union karo
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i); 

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                } else {
                    // Agar email pehle se kisi account mai hai, to dono ko jod do
                    union(i, emailToId.get(email), parent);
                }
            }
        }

        // Step 2: Same Ultimate Boss (Root) waale emails ko group karo
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int id = emailToId.get(email);
            int rootId = find(id, parent); // Ultimate parent nikala

            mergedAccounts.putIfAbsent(rootId, new ArrayList<>());
            mergedAccounts.get(rootId).add(email);
        }

        // Step 3: Emails ko sort karo aur Owner Name attach karke final list banao
        List<List<String>> result = new ArrayList<>();
        for (int rootId : mergedAccounts.keySet()) {
            List<String> emails = mergedAccounts.get(rootId);
            Collections.sort(emails); // Sorting compulsory hai

            List<String> component = new ArrayList<>();
            component.add(accounts.get(rootId).get(0)); // Name add kiya
            component.addAll(emails); // Saare sorted emails add kiye
            
            result.add(component);
        }

        return result;
    }
}