package com.intellekta.generics.middleearth;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cavalry cavalry = new Cavalry() {};
        MordorUnit mordorUnit = new MordorUnit() {};
        Infantry infantry = new Infantry() {};

        MiddleEarthUnit middleEarthUnit = new MiddleEarthUnit() {
        };

        Army<MordorUnit> army = new Army<>(mordorUnit);
        army.recruit(cavalry);
        army.recruit(infantry);
        army.recruit(cavalry);
        army.realise(cavalry);
        army.print();
    }
}
