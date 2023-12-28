package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;
import com.intellekta.generics.middleearth.units.abstracts.MiddleEarthUnit;

public class Elf extends AbstractInfantry implements MiddleEarthUnit, Infantry {
    public Elf(String name) {
        super(name, 4, 7);
    }
}
