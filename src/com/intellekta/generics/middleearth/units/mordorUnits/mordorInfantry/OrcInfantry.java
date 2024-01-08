package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Orc;

public class OrcInfantry extends AbstractInfantry implements Orc, Infantry {
    public OrcInfantry(String name) {
        super(name, 8, 10);
    }
}
