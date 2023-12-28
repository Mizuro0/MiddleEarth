package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;
import com.intellekta.generics.middleearth.units.abstracts.Orc;

public class OrcInfantry extends AbstractInfantry implements Orc, Infantry {
    protected OrcInfantry(String name) {
        super(name, 8, 10);
    }
}
