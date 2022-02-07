package com.underlying;

import java.util.HashSet;

public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            objects.add(i);
        }
    }
}
