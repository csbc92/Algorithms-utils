package dk.sdu.mmmi.algo.utils;

import dk.sdu.mmmi.algo.utils.datastructures.Element;
import dk.sdu.mmmi.algo.utils.datastructures.MinPQHeap;

public class HeapTest {
    public static void main(String[] args) {
        MinPQHeap heap = new MinPQHeap(10);

        heap.insert(new Element(2, null));
        heap.insert(new Element(4, null));
        heap.insert(new Element(5, null));
        heap.insert(new Element(8, null));
        heap.insert(new Element(7, null));
        heap.insert(new Element(6, null));
        heap.insert(new Element(6, null));
        heap.insert(new Element(9, null));

        heap.insert(new Element(1, null));
        heap.insert(new Element(2, null));

        //heap.extractMin();

        //heap.insert(new Element(1, null));

        System.out.println(heap);

    }
}
