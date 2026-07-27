class Solution {
    // Purane node se naye cloned node ko map karne ke liye
    private HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // Base Case: Agar input node hi null hai, toh null return karo
        if (node == null) {
            return null;
        }
        // Agar is node ka clone pehle hi ban chuka hai, toh use map se return kar do
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        // 1. Naya node banao (Clone taiyar karo)
        Node cloneNode = new Node(node.val);
        
        // 2. Map me entry dalo: [Purana Node -> Naya Cloned Node]
        map.put(node, cloneNode);
        
        // 3. Ab purane node ke saare padosiyon (neighbors) par ghoomo
        for (Node neighbor : node.neighbors) {
            // Har padosi ka clone recursive DFS se mangwao 
            // Aur naye cloned node ke neighbors list me add kar do
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        // Final cloned graph ka root return kar do
        return cloneNode;
    }
}