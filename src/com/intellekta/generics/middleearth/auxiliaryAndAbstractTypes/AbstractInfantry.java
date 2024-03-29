package com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes;

public class AbstractInfantry extends AbstractUnit implements Infantry {

    protected AbstractInfantry(String name, int minPower, int maxPower) {
        super(name, minPower, maxPower);
    }

    @Override
    protected void receiveDamage(int damage) {
        power -= damage;
    }
}
