package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.MordorUnit;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorCavalry.OrcCavalry;

public class Main {
    public static void main(String[] args) {
        MordorUnit mordorUnit = new MordorUnit() {};
        Cavalry mordorUnit1 = new OrcCavalry("Ss");
        Army<MordorUnit> army = new Army<>(mordorUnit);
        army.getRandomUnit((MordorUnit) mordorUnit1);
        System.out.println("hello");
    }
}
