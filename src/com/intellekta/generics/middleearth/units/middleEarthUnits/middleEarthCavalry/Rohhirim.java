package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Human;

public class Rohhirim extends AbstractInfantry implements Human, Cavalry {
    public Rohhirim(String name) {
        super(name, 7, 8);
    }
}
