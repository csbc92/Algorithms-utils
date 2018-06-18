package dk.sdu.mmmi.algo.utils;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

public class Hashing {
    /**
     * Linear Probing page 272 in Cormen
     * Inserts the key into the hash table and returns the index.
     * @param table
     * @param key
     * @return
     */
    public static Integer hashInsertLinearProbing(Integer[] table, int key) {
        int i = 0;
        int m = table.length;

        do {
            int j = (hashFunction1(key) + i) % m;// = h(k, i) = (h'(x) + i) mod m)
            if (table[j] == null) {
                table[j] = key;
                return j;
            } else {
                i++;
            }
        } while (i != m);

        return null;
    }

    /**
     * Double hashing with probing page 272 in Cormen.
     * @param table
     * @param key
     * @return
     */
    public static Integer hashInsertDoubleHashing(Integer[] table, int key) {
        int i = 0;
        int m = table.length;

        do {
            int j = (hashFunction1(key) + i*(hashFunction2(key))) % m;
            if (table[j] == null) {
                table[j] = key;
                return j;
            } else {
                i++;
            }
        } while (i != m);

        return null;
    }

    /**
     * Quadratic hashing with probing page 272 in Cormen.
     * @param table
     * @param key
     * @return
     */
    public static Integer hashInsertQuadraticHashing(Integer[] table, int key, int c1, int c2) {
        int i = 0;
        int m = table.length;

        do {
            int j = (hashFunction1(key) + c1*i + c2*i*i) % m;
            if (table[j] == null) {
                table[j] = key;
                return j;
            } else {
                i++;
            }
        } while (i < m);

        return null;
    }

    private static int hashFunction1(int key) {
        return (7*key+4) % 11; // This method can be update to match h'(x) given in the task..
    }

    private static int hashFunction2(int key) {
        return (key % 6) + 1; // This method can be update to match h''(x) given in the task..
    }

    private static void runLinearProbeHashing(Integer[] hashTable, int key) {
        Integer index = hashInsertLinearProbing(hashTable, key);
        System.out.println("Inserting " + key + " on index: " + index);
        System.out.println("Resulting hash table: " + Arrays.toString(hashTable));
    }

    private static void runDoubleHashing(Integer[] hashTable, int key) {
        Integer index = hashInsertDoubleHashing(hashTable, key);
        System.out.println("Inserting " + key + " on index: " + index);
        System.out.println("Resulting hash table: " + Arrays.toString(hashTable));
    }

    private static void runQuadraticHashing(Integer[] hashTable, int key, int constant1, int constant2) {
        Integer index = hashInsertQuadraticHashing(hashTable, key, constant1, constant2);
        System.out.println("Inserting " + key + " on index: " + index);
        System.out.println("Resulting hash table: " + Arrays.toString(hashTable));
    }

    private static void runDoubleHashingExampleFromBook() {
        Integer[] table = new Integer[] {null, 79, null, null, 69, 98, null, 72, null, null, null, 50, null};
        int key = 14;

        int index = hashInsertDoubleHashing(table, key);
        System.out.println("Inserting " + key + " on index: " + index);
        System.out.println("Resulting hash table: " + Arrays.toString(table));
    }

    public static void main(String[] args) {
        // OBS: Remember to update both hashFunction1() and hashFunction2() to those given in the task..
        // OBS: Remember to update the key to be inserted and the table before running the program..
        Integer[] hashTable = new Integer[] {67, 20, 17, null, 33, null, 16, 2, null, null, 15};

        runLinearProbeHashing(hashTable, 18);
        runLinearProbeHashing(hashTable, 26);
        //runDoubleHashing(hashTable, key);
        //runDoubleHashingExampleFromBook();
        //runQuadraticHashing(hashTable, 22, 3, 1); // OBS: Remember to change the constants if they are given by the task..
    }
}
