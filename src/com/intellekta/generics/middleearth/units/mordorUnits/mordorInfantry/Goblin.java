package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;
import com.intellekta.generics.middleearth.units.abstracts.MordorUnit;

public class Goblin extends AbstractInfantry implements MordorUnit, Infantry {
    public Goblin(String name) {
        super(name, 2, 5);
    }
}
