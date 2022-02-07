//: enumerated/Competitor.java
// Switching one enum on another.
package com.thinkInJava.chapter19bk;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
} ///:~
