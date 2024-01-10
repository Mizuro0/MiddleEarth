package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractCavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.MiddleEarthUnit;

public class Wizard extends AbstractCavalry implements MiddleEarthUnit, Cavalry {
    public Wizard(String name) {
        super(name, 20, 20);
    }
}
