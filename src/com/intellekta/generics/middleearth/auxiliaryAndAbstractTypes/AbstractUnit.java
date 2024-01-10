package com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes;

import java.util.Random;

public abstract class AbstractUnit implements Unit {
    protected String name;
    protected int power;

    protected AbstractUnit(String name, int minPower, int maxPower) {
        this.name = name;
        Random random = new Random();
        this.power = random.nextInt(maxPower - minPower + 1) + minPower;
    }

    public boolean isAlive() {
        return this.power > 0;
    }

    public <T> void strike(T t) {
        if (t instanceof AbstractUnit) {
            AbstractUnit target = (AbstractUnit) t;
            target.receiveDamage(this.power);
        }
    }

    protected abstract void receiveDamage(int damage);

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
