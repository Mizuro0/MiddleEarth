package com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry;

import com.intellekta.generics.middleearth.units.abstracts.AbstractCavalry;
import com.intellekta.generics.middleearth.units.abstracts.Cavalry;
import com.intellekta.generics.middleearth.units.abstracts.Human;

public class HumanCavalry extends AbstractCavalry implements Human, Cavalry {

    public HumanCavalry(String name) {
        super(name, 7, 8);
    }
}
