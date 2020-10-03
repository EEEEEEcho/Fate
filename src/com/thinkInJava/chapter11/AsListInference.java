package com.thinkInJava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow{

}
class Power extends Snow{

}
class Heavy extends Power{

}
class Light extends Power{

}
class Cursty extends Snow{

}
class Slush extends Snow{

}
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Cursty(),new Slush(),new Power());
        //List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());会报错，因为Arrays.asList()中只有Power类型
        //因此会创建一个Power类型
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,new Light(),new Heavy());
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy());    //这样可以
    }
}
