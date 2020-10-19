package com.thinkInJava.chapter16;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<String>();
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();
        List<BerylliumSphere>[] sphere = (List<BerylliumSphere>[]) new List[10];
        for(int i=0;i < sphere.length;i ++){
            sphere[i] = new ArrayList<BerylliumSphere>();
        }
    }
}
