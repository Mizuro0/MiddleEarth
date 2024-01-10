package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.MordorUnit;

public class Troll extends AbstractInfantry implements MordorUnit, Infantry {
    public Troll(String name) {
        super(name, 11, 15);
    }
}
