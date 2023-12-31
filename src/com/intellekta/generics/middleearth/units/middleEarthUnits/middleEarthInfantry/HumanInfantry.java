package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Human;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Infantry;

public class HumanInfantry extends AbstractInfantry implements Human, Infantry {
    public HumanInfantry(String name) {
        super(name, 7, 8);
    }
}
