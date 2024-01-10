package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.MiddleEarthUnit;

public class WoodenElf extends AbstractInfantry implements MiddleEarthUnit, Infantry {
    public WoodenElf(String name) {
        super(name, 6, 6);
    }
}
