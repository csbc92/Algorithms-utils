package dk.sdu.mmmi.algo.utils.datastructures;

/**
 * Priority Queue Heap implementation.
 * Lavet af Christian Skafte Beck Clausen Chcla15 og Daniel Johansen Dajoh16
 */
public class MinPQHeap implements MinPQ {

    private Element[] elements;
    private int heapSize;

    public MinPQHeap(int maxElements) {
        elements = new Element[maxElements];
        heapSize = -1;

    }

    /**
     * Extracts the root element which is the min element
     *
     * @return
     */
    @Override
    public Element extractMin() {
        Element min = elements[0];
        elements[0] = elements[heapSize];
        heapSize--;
        minHeapify(0);
        return min;
    }

    /**
     * Inserts an element into the priority queue heap
     *
     * @param element
     */
    @Override
    public void insert(Element element) {
        heapSize++;
        int i = heapSize;

        elements[i] = element;

        if(parent(i) < 0){
            return;
        }

        if (elements[parent(i)] != null && elements[i] != null) {
            while (i > 0 && elements[parent(i)].key > elements[i].key) {
                Element temp = elements[parent(i)];
                elements[parent(i)] = elements[i];
                elements[i] = temp;
                i = parent(i);
            }
        }
    }

    /**
     * A heap-decrease-key algorithm derived from increase key algorithm page 164 in Cormen
     * @param i
     * @param key
     */
    @Override
    public void decreaseKey(int i, int key) {
        if (key > elements[i].key)
            throw new Error("New key is larger than current key");

        elements[i].key = key;

        while (i > 0 && elements[parent(i)].key > elements[i].key) {
            Element temp = elements[i];
            elements[i] = elements[parent(i)];
            elements[parent(i)] = temp;

            i = parent(i);
        }
    }

    @Override
    public int size() {
        return this.heapSize;
    }

    @Override
    public boolean exists(Element e) {
        for (int i = 0; i <= heapSize; i++) {
            if (elements[i] == e) {
                return true;
            }
        }

        return false;
    }

    /**
     * Rebuilds the heap based on a min heap structure. The call is recursive.
     *
     * @param i
     */
    public void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest;
        if (left <= heapSize && elements[left].key < elements[i].key) {
            smallest = left;
        } else {
            smallest = i;
        }
        if (right <= heapSize && elements[right].key < elements[smallest].key) {
            smallest = right;
        }
        if (smallest != i) {
            Element temp = elements[smallest];
            elements[smallest] = elements[i];
            elements[i] = temp;
            minHeapify(smallest);
        }
    }

    @Override
    public int getIndex(Element e) {
        for (int i = 0; i <= heapSize; i++) {
            if (elements[i] == e) {
                return i;
            }
        }

        return -1;
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
        int[] keys = new int[] {18, 9, 16, 4, 8, 12, 13, 3, 5};
        MinPQ minPQ = new MinPQHeap(keys.length);
        for (int i = 0; i < keys.length; i++) {
            minPQ.insert(new Element(keys[i], null));
        }
        // Print the max heap array
        System.out.println("Max heap array: " + minPQ);

        // Decrease key on index 6 to 1
        minPQ.decreaseKey(6, 1);
        // Print the max heap array
        System.out.println("Max heap array: " + minPQ);

        // Extract the key
        int minKey = minPQ.extractMin().key;
        // Print the max heap array
        System.out.println("Max heap array: " + minPQ);
    }
}


