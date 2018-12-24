import java.util.HashMap;
import java.util.Map;

public class Problem133_clone_graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        clone(node, visited);
        return visited.get(node.label);
    }

    private void clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.label)) {
                clone(neighbor, visited);
            }
            newNode.neighbors.add(visited.get(neighbor.label));
        }
    }
}
