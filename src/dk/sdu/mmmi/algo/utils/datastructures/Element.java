package dk.sdu.mmmi.algo.utils.datastructures;

/**
 * Created by danie on 02-03-2018.
 */
public class Element {
    public int key;
    public Object data;
    public Element parent;

    public Element(int key, Object data) {
        this.key = key;
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
