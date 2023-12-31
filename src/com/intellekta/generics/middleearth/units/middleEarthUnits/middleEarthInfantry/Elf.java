package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.MiddleEarthUnit;

public class Elf extends AbstractInfantry implements MiddleEarthUnit, Infantry {
    public Elf(String name) {
        super(name, 4, 7);
    }
}
