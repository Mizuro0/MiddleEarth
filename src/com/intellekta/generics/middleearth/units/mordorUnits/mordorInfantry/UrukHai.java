package com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Infantry;
import com.intellekta.generics.middleearth.units.abstracts.Orc;

public class UrukHai extends AbstractInfantry implements Orc, Infantry {
    public UrukHai(String name) {
        super(name, 10, 12);
    }
}
