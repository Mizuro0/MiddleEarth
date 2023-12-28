package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;
import com.intellekta.generics.middleearth.units.abstracts.MiddleEarthUnit;

public class WoodenElf extends AbstractInfantry implements MiddleEarthUnit, Infantry {
    public WoodenElf(String name) {
        super(name, 6, 6);
    }
}
