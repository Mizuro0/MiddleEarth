package com.intellekta.generics.middleearth.units.mordorUnits.mordorCavalry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractCavalry;
import com.intellekta.generics.middleearth.units.abstracts.Cavalry;
import com.intellekta.generics.middleearth.units.abstracts.Orc;

public class OrcCavalry extends AbstractCavalry implements Orc, Cavalry {
    protected OrcCavalry(String name) {
        super(name, 8, 10);
    }
}
