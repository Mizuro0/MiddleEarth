package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractInfantry;
import com.intellekta.generics.middleearth.units.abstracts.Cavalry;
import com.intellekta.generics.middleearth.units.abstracts.Human;

public class Rohhirim extends AbstractInfantry implements Human, Cavalry {
    protected Rohhirim(String name) {
        super(name, 7, 8);
    }
}
