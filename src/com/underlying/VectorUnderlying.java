package com.underlying;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class VectorUnderlying {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
    }
}
