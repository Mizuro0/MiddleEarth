package com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits;

import java.util.Random;

public abstract class AbstractCavalry implements Cavalry {

    String name;

    String subclass;
    protected int power;
    protected Mount mount;

    protected AbstractCavalry(String name, int minPower, int maxPower) {
        this.name = name;
        subclass = this.getClass().getSimpleName();

        Random random = new Random();
        this.power = random.nextInt(maxPower - minPower + 1) + minPower;
        if (subclass.equals("HumanCavalry")) {
            mount = new Horse();
        } else if (subclass.equals("OrcCavalry")) {
            mount = new Warg();
        }
    }


    protected abstract class Mount implements Unit {
        protected int power;
        protected Mount(int minPower, int maxPower) {
            Random random = new Random();
            this.power = random.nextInt((maxPower - minPower + 1) + minPower);
        }
        protected boolean isAlive() {
            if(this.power > 0) return true;
            else return false;
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



    protected boolean isAlive(){
        if(power > 0) {
            return true;
        }
        else return false;
    }

    public  <T> void strike(T t) {
        if(t instanceof AbstractCavalry) {
            if (((AbstractCavalry) t).mount.isAlive()) {
                ((AbstractCavalry) t).mount.power -= this.power;
            }
            if (((AbstractCavalry) t).isAlive() && !((AbstractCavalry) t).mount.isAlive()) {
                ((AbstractCavalry) t).power -= this.power;
            }
        }
        if(t instanceof AbstractInfantry) {
            ((AbstractInfantry) t).power -= this.power;
        }
    }
}
