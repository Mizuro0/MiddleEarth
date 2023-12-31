package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.MordorUnit;

public class Goblin extends AbstractInfantry implements MordorUnit, Infantry {
    public Goblin(String name) {
        super(name, 2, 5);
    }
}
