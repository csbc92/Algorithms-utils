package dk.sdu.mmmi.algo.utils.datastructures;

import java.util.Arrays;

public class MaxPQHeap implements MaxPQ {
    private Element[] elements;
    private int heapSize;

    public MaxPQHeap(int maxElements) {
        elements = new Element[maxElements];
        heapSize = -1;

    }

    @Override
    public Element extractMax() {
        Element max = elements[0];
        elements[0] = elements[heapSize];
        heapSize--;
        maxHeapify(0);
        return max;
    }

    @Override
    public void insert(Element element) {
        heapSize++;
        int i = heapSize;

        elements[i] = element;

        if(parent(i) < 0){
            return;
        }

        if (elements[parent(i)] != null && elements[i] != null) {
            while (i > 0 && elements[parent(i)].key < elements[i].key) {
                Element temp = elements[parent(i)];
                elements[parent(i)] = elements[i];
                elements[i] = temp;
                i = parent(i);
            }
        }
    }

    /**
     * Heap-increase-key algorithm from page 164 Cormen
     * @param i
     * @param key
     */
    @Override
    public void increaseKey(int i, int key) {
        if (key < elements[i].key) {
            throw new Error("New key is smaller than current key");
        }

        elements[i].key = key;

        while (i > 0 && elements[parent(i)].key < elements[i].key) {
            Element temp = elements[i];
            elements[i] = elements[parent(i)];
            elements[parent(i)] = temp;
            i = parent(i);
        }
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest;
        if (left <= heapSize && elements[left].key > elements[i].key) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= heapSize && elements[right].key > elements[largest].key) {
            largest = right;
        }
        if (largest != i) {
            Element temp = elements[largest];
            elements[largest] = elements[i];
            elements[i] = temp;
            maxHeapify(largest);
        }
    }

    /**
     * returns the left node index
     * @param i
     * @return
     */
    private int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the right node index
     * @param i
     * @return
     */
    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     *
     * Returns -1 if at root.
     *
     * @param i
     * @return
     */
    private int parent(int i) {
        int parent = (int) (Math.ceil(i / 2D) - 1);
        return parent;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i <= heapSize; i++) {
            if (sb.length() > 1) {
                sb.append(", ");
            }

            sb.append(elements[i].key);
        }

        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {

        // Initialize the Max Priority Queue (Max Heap)
        int[] keys = new int[] {18, 9, 16, 4, 8, 12, 13, 1, 2};
        MaxPQ maxPQ = new MaxPQHeap(keys.length);
        for (int i = 0; i < keys.length; i++) {
            maxPQ.insert(new Element(keys[i], null));
        }
        // Print the max heap array
        System.out.println("Max heap array: " + maxPQ);

        // Increase a key in the heap
        maxPQ.increaseKey(8, 15); // IncreaseKey is 0-indexed
        // Print the max heap array
        System.out.println("Max heap array: " + maxPQ);

        // Extract the key
        int maxKey = maxPQ.extractMax().key;
        // Print the max heap array
        System.out.println("Max heap array: " + maxPQ);
    }
}
