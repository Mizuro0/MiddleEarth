package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractCavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.MiddleEarthUnit;

public class Wizard extends AbstractCavalry implements MiddleEarthUnit, Cavalry {
    public Wizard(String name) {
        super(name, 20, 20);
    }
}
