package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Human;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Infantry;

public class HumanInfantry extends AbstractInfantry implements Human, Infantry {
    public HumanInfantry(String name) {
        super(name, 7, 8);
    }
}
