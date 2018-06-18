package dk.sdu.mmmi.algo.utils.graphalgorithms;

import dk.sdu.mmmi.algo.utils.datastructures.Element;
import dk.sdu.mmmi.algo.utils.datastructures.MinPQ;
import dk.sdu.mmmi.algo.utils.datastructures.MinPQHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrimJarnik {

    private HashMap<Element, List<Element>> graph;
    private HashMap<Tuple<Element, Element>, Integer> weights;
    private Element root;

    private MinPQ minPQ;

    public PrimJarnik(HashMap<Element, List<Element>> graph, HashMap<Tuple<Element, Element>, Integer> weights, Element root) {
        this.graph = graph;
        this.weights = weights;
        this.root = root;
    }

    /**
     * Returns the minimum spanning tree in pairs of Vertices.
     * Algorithm found on page 634 Cormen.
     */
    public List<Tuple<Element, Element>> minimumSpanningTreePrim() {

        List<Tuple<Element, Element>> minimumSpanningTreePairs = new ArrayList<>();

        // Initialize the vertices in the graph
        for (Element vertex : graph.keySet()) {
            vertex.key = Integer.MAX_VALUE;
            vertex.parent = null;
        }

        root.key = 0;

        // Initialize the priority queue
        minPQ = new MinPQHeap(graph.keySet().size());
        for (Element vertex : graph.keySet()) {
            minPQ.insert(vertex);
        }

        while (minPQ.size() >= 0) {
            System.out.println("Priority queue BEFORE extract: " + minPQ);
            Element u = minPQ.extractMin();
            if (u.parent != null) {
                minimumSpanningTreePairs.add(new Tuple<>(u, u.parent));
            }
            System.out.println("Priority queue AFTER extract: " + u.data + "=" + u.key + " -> " + minPQ);

            for (Element adjecentVertex: graph.get(u)) {
                if (minPQ.exists(adjecentVertex) && weights.get(new Tuple(u, adjecentVertex)) < adjecentVertex.key) {
                    adjecentVertex.parent = u;
                    minPQ.decreaseKey(minPQ.getIndex(adjecentVertex), weights.get(new Tuple(u, adjecentVertex)));
                }
            }
        }

        return minimumSpanningTreePairs;
    }

    public static void main(String[] args) {

        HashMap graph = new HashMap<Element, List<Element>>();
        Element a = new Element(0, "a");
        Element b = new Element(0, "b");
        Element c = new Element(0, "c");
        Element d = new Element(0, "d");
        Element e = new Element(0, "e");


        graph.put(a, new ArrayList<Element>() {{
            add(b);
            add(e);
            add(d);
        }});

        graph.put(b, new ArrayList<Element>() {{
            add(a);
            add(e);
            add(c);
        }});

        graph.put(e, new ArrayList<Element>() {{
            add(a);
            add(b);
            add(d);
            add(c);
        }});

        graph.put(d, new ArrayList<Element>() {{
            add(a);
            add(e);
            add(c);
        }});

        graph.put(c, new ArrayList<Element>() {{
            add(b);
            add(e);
            add(d);
        }});

        HashMap<Tuple<Element, Element>, Integer> weights = new HashMap<>();
        weights.put(new Tuple<>(a, b), 17);
        weights.put(new Tuple<>(a, e), 11);
        weights.put(new Tuple<>(a, d), 8);

        weights.put(new Tuple<>(b, a), 17);
        weights.put(new Tuple<>(b, e), 5);
        weights.put(new Tuple<>(b, c), 14);

        weights.put(new Tuple<>(c, b), 17);
        weights.put(new Tuple<>(c, e), 3);
        weights.put(new Tuple<>(c, d), 25);

        weights.put(new Tuple<>(d, a), 8);
        weights.put(new Tuple<>(d, e), 18);
        weights.put(new Tuple<>(d, c), 25);

        weights.put(new Tuple<>(e, a), 11);
        weights.put(new Tuple<>(e, b), 5);
        weights.put(new Tuple<>(e, c), 3);
        weights.put(new Tuple<>(e, d), 25);

        PrimJarnik primJarnik = new PrimJarnik(graph, weights, a);
        System.out.println("Minimum spanning tree: " + primJarnik.minimumSpanningTreePrim());
    }
}
