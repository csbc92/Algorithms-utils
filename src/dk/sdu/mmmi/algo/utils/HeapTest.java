package dk.sdu.mmmi.algo.utils;

import dk.sdu.mmmi.algo.utils.datastructures.Element;
import dk.sdu.mmmi.algo.utils.datastructures.MinPQHeap;

public class HeapTest {
    public static void main(String[] args) {
        MinPQHeap heap = new MinPQHeap(9);

        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));
        heap.insert(new Element(2, null));

        heap.extractMin();

        heap.insert(new Element(1, null));

        System.out.println(heap);

    }
}
