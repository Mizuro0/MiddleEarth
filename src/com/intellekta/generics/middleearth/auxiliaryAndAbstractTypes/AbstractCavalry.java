package com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes;

import java.util.Random;

public abstract class AbstractCavalry extends AbstractUnit implements Cavalry {
    protected Mount mount;

    protected AbstractCavalry(String name, int minPower, int maxPower) {
        super(name, minPower, maxPower);
        if (this instanceof MiddleEarthUnit) {
            mount = new Horse();
        } else if (this instanceof MordorUnit) {
            mount = new Warg();
        }
    }

    @Override
    protected void receiveDamage(int damage) {
        if (mount != null) {
            if (mount.isAlive()) {
                mount.power -= damage;
            }
            if (isAlive() && !mount.isAlive()) {
                power -= damage;
            }
        }
    }

    protected abstract class Mount implements Unit {
        Random random = new Random();
        protected int power;

        protected Mount(int minPower, int maxPower) {
            this.power = random.nextInt(maxPower - minPower + 1) + maxPower;
        }

        protected boolean isAlive() {
            return power > 0;
        }
    }

    protected class Horse extends Mount {
        protected Horse() {
            super(4, 5);
        }
    }

    protected class Warg extends Mount {
        protected Warg() {
            super(4, 7);
        }
    }
}
