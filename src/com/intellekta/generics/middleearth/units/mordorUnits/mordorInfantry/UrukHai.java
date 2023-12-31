package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.AbstractInfantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Orc;

public class UrukHai extends AbstractInfantry implements Orc, Infantry {
    public UrukHai(String name) {
        super(name, 10, 12);
    }
}
