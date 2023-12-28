package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractCavalry;
import com.intellekta.generics.middleearth.units.abstracts.Cavalry;
import com.intellekta.generics.middleearth.units.abstracts.MiddleEarthUnit;

public class Wizard extends AbstractCavalry implements MiddleEarthUnit, Cavalry {
    public Wizard(String name) {
        super(name, 20, 20);
    }
}
