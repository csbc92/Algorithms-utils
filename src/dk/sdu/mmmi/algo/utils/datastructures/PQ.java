package dk.sdu.mmmi.algo.utils.datastructures;

/**
 * Created by danie on 02-03-2018.
 */
public interface PQ {
    public Element extractMin();
    public void insert(Element e);
}
