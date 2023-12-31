package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Human;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;

public class HumanInfantry extends AbstractInfantry implements Human, Infantry {
    public HumanInfantry(String name) {
        super(name, 7, 8);
    }
}
