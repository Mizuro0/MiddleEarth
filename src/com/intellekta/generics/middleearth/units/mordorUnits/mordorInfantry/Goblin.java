package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.MordorUnit;

public class Goblin extends AbstractInfantry implements MordorUnit, Infantry {
    public Goblin(String name) {
        super(name, 2, 5);
    }
}
