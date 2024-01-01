package com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits;

import java.util.Random;

public class AbstractInfantry implements Infantry{
    String name;

    protected int power;

    protected AbstractInfantry(String name, int minPower, int maxPower) {
        this.name = name;
        Random random = new Random();
        this.power = random.nextInt((maxPower - minPower + 1) + minPower);
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
