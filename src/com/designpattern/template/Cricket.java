package com.designpattern.template;

public class Cricket extends Game{

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialize!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Start!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game End!");
    }
}
