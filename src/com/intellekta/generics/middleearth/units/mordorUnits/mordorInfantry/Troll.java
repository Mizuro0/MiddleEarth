package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;
import com.intellekta.generics.middleearth.units.abstracts.MordorUnit;

public class Troll extends AbstractInfantry implements MordorUnit, Infantry {
    public Troll(String name) {
        super(name, 11, 15);
    }
}
