package com.intellekta.generics.middleearth.units.mordorUnits.mordorCavalry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractCavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Orc;

public class OrcCavalry extends AbstractCavalry implements Orc, Cavalry {
    public OrcCavalry(String name) {
        super(name, 8, 10);
    }
}
