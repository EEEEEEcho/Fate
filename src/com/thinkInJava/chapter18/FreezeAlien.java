package com.thinkInJava.chapter18;//: io/FreezeAlien.java
// Create a serialized output file.

import java.io.*;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
} ///:~
