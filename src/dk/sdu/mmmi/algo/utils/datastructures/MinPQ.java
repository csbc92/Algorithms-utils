package dk.sdu.mmmi.algo.utils.datastructures;

/**
 * Created by danie on 02-03-2018.
 */
public interface MinPQ {
    public Element extractMin();
    public void insert(Element e);
    public void decreaseKey(int i, int key);
    public int size();
    public boolean exists(Element e);
    public void minHeapify(int i);
    public int getIndex(Element e);
}
