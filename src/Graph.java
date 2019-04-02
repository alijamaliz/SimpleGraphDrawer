import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private String label;

    public Graph(String label) {
        this.label = label;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public boolean addNode(String label) {
        if (isLabelExists(label))
            throw new IllegalArgumentException("Node label must be unique in graph");
        Node node = new Node(label);
        nodes.add(node);
        return true;
    }

    public boolean addEdge(Node source, Node target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(source) && edge.getTarget().equals(target))
                throw new IllegalArgumentException("Only one edge is possible between two nodes");
        }
        Edge edge = new Edge(source, target);
        edges.add(edge);
        return true;
    }

    public boolean addEdge(String sourceLabel, String targetLabel) {
        Node source = findNodeByLabel(sourceLabel);
        Node target = findNodeByLabel(targetLabel);
        if (source == null || target == null)
            throw new IllegalArgumentException("Node with sourceLabel or targetLabel not found");
        return addEdge(source, target);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    private Node findNodeByLabel(String label) {
        for (Node node : nodes) {
            if (node.getLabel().equals(label))
                return node;
        }
        return null;
    }

    private boolean isLabelExists(String label) {
        Node temp = findNodeByLabel(label);
        if (temp != null)
            return true;
        return false;
    }
}
