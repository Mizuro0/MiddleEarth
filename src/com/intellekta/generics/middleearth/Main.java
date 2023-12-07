package com.intellekta.generics.middleearth;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army<MordorUnit> army = new Army<>(new MordorUnit());
        army.recruit("Cavalry");
        army.recruit("Infantry");
        System.out.println("hello");
    }
}
