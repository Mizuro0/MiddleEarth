package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Orc;

public class OrcInfantry extends AbstractInfantry implements Orc, Infantry {
    protected OrcInfantry(String name) {
        super(name, 8, 10);
    }
}
