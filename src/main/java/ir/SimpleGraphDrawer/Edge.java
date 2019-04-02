package ir.SimpleGraphDrawer;

public class Edge {
    private Node source;
    private Node target;
    private int weight;
    private String label;

    public Edge(Node source, Node target) {
        this.source = source;
        this.target = target;
    }

    public Edge(Node source, Node target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.label = "label";
    }

    public Edge(Node source, Node target, String label) {
        this.source = source;
        this.target = target;
        this.label = label;
        this.weight = 1;
    }

    public Edge(Node source, Node target, int weight, String label) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.label = label;
    }

    public int getWeight() {
        return weight;
    }

    public String getLabel() {
        return label;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }
}
