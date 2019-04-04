package ir.SimpleGraphDrawer;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph("test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Adding node to graph")
    @Order(1)
    void addNode() {
        String nodeLabel = "test";
        int beforeSize = graph.getNodes().size();
        graph.addNode(nodeLabel);
        int afterSize = graph.getNodes().size();

        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("node",
                () -> assertEquals(beforeSize + 1, afterSize),
                () -> assertEquals(graph.getNodes().get(graph.getNodes().size() - 1).getLabel(), nodeLabel)
        );
    }

    @Test
    @DisplayName("Adding node with duplicate label")
    @Order(2)
    void addDuplicateNode() {
        graph.addNode("test");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addNode("test"));
        assertEquals("Node label must be unique in graph", exception.getMessage());
    }

    @Test
    @DisplayName("Adding node with null label")
    @Order(3)
    void addNullNode() {
        Exception exception = assertThrows(NullPointerException.class, () -> graph.addNode(null));
        assertEquals("Node label can hot be null", exception.getMessage());
    }


    @Test
    @DisplayName("Adding edge with wrong node label")
    @Order(4)
    void addEdge() {
        graph.addNode("foo");
        graph.addNode("bar");
        int beforeSize = graph.getEdges().size();
        graph.addEdge("foo", "bar");
        int afterSize = graph.getEdges().size();
        assertEquals(beforeSize + 1, afterSize);
    }

    @Test
    @DisplayName("Adding edge with nodes label")
    @Order(5)
    void addEdgeWithWrongNodeLabel() {
        graph.addNode("foo");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                graph.addEdge("foo", "bar")
        );
        assertEquals("Node with sourceLabel or targetLabel not found", exception.getMessage());
    }

    @Test
    @DisplayName("Adding duplicate edge")
    @Order(6)
    void addDuplicateEdge() {
        graph.addNode("foo");
        graph.addNode("bar");
        graph.addEdge("foo", "bar");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                graph.addEdge("foo", "bar")
        );
        assertEquals("Only one edge is possible between two nodes", exception.getMessage());
    }

    @Test
    @DisplayName("Getting edges method")
    void getEdges() {
        assertEquals(0, graph.getEdges().size());

        String firstNodeLabel = "first-foo";
        String secondNodeLabel = "first-bar";
        String thirdNodeLabel = "second-foo";
        String forthNodeLabel = "second-bar";
        graph.addNode(firstNodeLabel);
        graph.addNode(secondNodeLabel);
        graph.addNode(thirdNodeLabel);
        graph.addNode(forthNodeLabel);

        int beforeSize = graph.getEdges().size();
        graph.addEdge(firstNodeLabel, secondNodeLabel);
        graph.addEdge(firstNodeLabel, thirdNodeLabel);
        graph.addEdge(thirdNodeLabel, forthNodeLabel);
        int afterSize = graph.getEdges().size();

        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("node",
                () -> assertEquals(beforeSize + 3, afterSize),
                () -> assertEquals(graph.getEdges().get(1).getSource().getLabel(), firstNodeLabel),
                () -> assertEquals(graph.getEdges().get(1).getTarget().getLabel(), thirdNodeLabel)
        );
    }

    @Test
    @DisplayName("Getting nodes method")
    void getNodes() {
        assertEquals(0, graph.getNodes().size());

        String firstNodeLabel = "first-foo";
        String secondNodeLabel = "first-bar";
        String thirdNodeLabel = "second-foo";
        String forthNodeLabel = "second-bar";


        int beforeSize = graph.getNodes().size();
        graph.addNode(firstNodeLabel);
        graph.addNode(secondNodeLabel);
        graph.addNode(thirdNodeLabel);
        graph.addNode(forthNodeLabel);
        int afterSize = graph.getNodes().size();

        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("node",
                () -> assertEquals(beforeSize + 4, afterSize),
                () -> assertEquals(graph.getNodes().get(1).getLabel(), secondNodeLabel),
                () -> assertEquals(graph.getNodes().get(3).getLabel(), forthNodeLabel)
        );
    }

    @RepeatedTest(10)
    @DisplayName(RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTest() {
        for (int i = 0; i < 100; i++)
            graph.addNode("Node" + i);
        assertTrue(graph.getRandomNode() instanceof Node);
    }
}