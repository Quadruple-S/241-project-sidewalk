import static org.junit.Assert.*;

import org.junit.Test;

import java.net.URL;
import java.io.FileNotFoundException;

import java.util.LinkedList;
import java.util.HashMap;

public class ShortestPathsTest {


    /* Returns the Graph loaded from the file with filename fn. */
    private Graph loadBasicGraph(String fn) {
        Graph result = null;
        try {
          result = ShortestPaths.parseGraph("basic", fn);
        } catch (FileNotFoundException e) {
          fail("Could not find graph " + fn);
        }
        return result;
    }

    /** Dummy test case demonstrating syntax to create a graph from scratch.
     * TODO Write your own tests below. */
    @Test
    public void test00Nothing() {
        Graph g = new Graph();
        Node a = g.getNode("A");
        Node b = g.getNode("B");
        g.addEdge(a, b, 1);

        // sample assertion statements:
        assertTrue(true);
        assertEquals(2+2, 4);
    }

    /** Minimal test case to check the path from A to B in Simple0.txt */
    @Test
    public void test01Simple0() {
        Graph g = loadBasicGraph("data/Simple0.txt");
        g.report();
        ShortestPaths sp = new ShortestPaths();
        Node a = g.getNode("A");
        sp.compute(a);
        Node b = g.getNode("B");
        LinkedList<Node> abPath = sp.shortestPath(b);
        assertEquals(abPath.size(), 2);
        assertEquals(abPath.getFirst(), a);
        assertEquals(abPath.getLast(),  b);
        assertEquals(sp.shortestPathLength(b), 1.0, 1e-6);
    }

    /*

    /** test if ShortestPaths will find the shortcut from A to B in Simple2.txt */
    @Test
    public void test02AwkwardPath() {
        Graph g = loadBasicGraph("data/Simple2.txt");
        g.report();
        ShortestPaths sp = new ShortestPaths();
        Node a = g.getNode("A");
        sp.compute(a);
        Node b = g.getNode("B");
        LinkedList<Node> abPath = sp.shortestPath(b);
        assertEquals(abPath.size(), 4);
	assertEquals(abPath.get(1).getId(), "E");
	assertEquals(abPath.get(2).getId(), "F");
    }

    /** test what happens when a node is unreachable*/
    @Test
    public void test03Unreachable() {
        Graph g = new Graph();
        Node a = g.getNode("A");
        Node b = g.getNode("B");
        g.addEdge(a, b, 1);

	ShortestPaths sp = new ShortestPaths();
	sp.compute(g.getNode("B"));
	LinkedList<Node> path = sp.shortestPath(g.getNode("A"));
	double pathLength = sp.shortestPathLength(g.getNode("A"));

	assertEquals(path, null);
	assertEquals(pathLength, Double.POSITIVE_INFINITY);
    }

    /**test wether or not distances are updated properly*/
    @Test
    public void test04UpdateDistances() {
	Graph g = new Graph();
        Node a = g.getNode("A");
        Node b = g.getNode("B");
        Node c = g.getNode("C");
        Node d = g.getNode("D");
	g.addEdge(a, d, 1000);
	g.addEdge(a, c, 1000);
	g.addEdge(a, c, 1000);
	g.addEdge(d, b, 1000);
	g.addEdge(c, a, 1);
	g.addEdge(a, b, 1);
	g.addEdge(b, c, 1);
	g.addEdge(c, d, 1);

	ShortestPaths sp = new ShortestPaths();
	sp.compute(a);
	LinkedList<Node> path = sp.shortestPath(d);
	double length = sp.shortestPathLength(d);
	
	assertEquals(path.toString(), "[A, B, C, D]");
	assertEquals(length, 3.0);
    }

    /**test calling compute multiple times*/
    @Test 
    public void test05Recompute() {
	Graph g = new Graph();
        Node a = g.getNode("A");
        Node b = g.getNode("B");
	g.addEdge(a, b, 1);
	g.addEdge(b, a, 5);
	
	ShortestPaths sp = new ShortestPaths();
	sp.compute(a);
	double lengthBefore = sp.shortestPathLength(b);

	sp.compute(b);
	double lengthAfter = sp.shortestPathLength(b);

	assertEquals(lengthBefore, 1);
	assertEquals(lengthAfter, 0);

    }
    
    /* Pro tip: unless you include @Test on the line above your method header,
     * JUnit will not run it! This gets me every time. */
}
