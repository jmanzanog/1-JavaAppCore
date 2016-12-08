package com.company;

import garbage.ObjectGarbage;

public class Main {

    public static void main(String[] args) {

        ObjectGarbage objectGarbage= new ObjectGarbage();
        objectGarbage= null;
        System.gc();


    }
}
