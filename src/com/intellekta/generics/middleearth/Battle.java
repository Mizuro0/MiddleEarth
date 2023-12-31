package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.ClassFinder;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.MordorUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {

    private Random random;
    private static List<Class<?>> classList;



    public static void fight() throws IOException, ClassNotFoundException {
        classList = ClassFinder.findClasses("com.intellekta.generics.middleearth.units");
        Army<MordorUnit> mordorArmy = new Army<>(new MordorUnit());
    }

    public static void fight(Army<?> firstArmy, Army<?> secondArmy) {


    }
}
