package ir.SimpleGraphDrawer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void getWeight() {
        Edge edge = new Edge(new Node("source"), new Node("target"));
        assertEquals(edge.getWeight(), 1);

        edge = new Edge(new Node("source"), new Node("target"), 3);
        assertEquals(edge.getWeight(), 3);
    }

    @Test
    void getLabel() {
        Edge edge = new Edge(new Node("source"), new Node("target"));
        assertEquals(edge.getLabel(), "label");

        edge = new Edge(new Node("source"), new Node("target"), "test");
        assertEquals(edge.getLabel(), "test");
    }
}