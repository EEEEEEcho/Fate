package com.thinkInJava.chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {
    private String s;
    public StringAddress(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(
                //放四个相同的StringAddress到List中
                Collections.nCopies(4,new StringAddress("Hello"))
        );
        System.out.println(list);
        //重新放相同的StringAddress到List中，也是四个了就
        Collections.fill(list,new StringAddress("World"));
        System.out.println(list);
    }
}
