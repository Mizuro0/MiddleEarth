package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractCavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Human;

public class HumanCavalry extends AbstractCavalry implements Human, Cavalry {

    public HumanCavalry(String name) {
        super(name, 7, 8);
    }
}
