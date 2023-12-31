package com.intellekta.generics.middleearth.units.mordorUnits.mordorCavalry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractCavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Orc;

public class OrcCavalry extends AbstractCavalry implements Orc, Cavalry {
    protected OrcCavalry(String name) {
        super(name, 8, 10);
    }
}
