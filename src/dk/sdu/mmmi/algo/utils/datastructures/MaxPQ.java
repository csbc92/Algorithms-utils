package dk.sdu.mmmi.algo.utils.datastructures;

public interface MaxPQ {
    public Element extractMax();
    public void insert(Element e);
    public void increaseKey(int i, int key);
}
