package com.intellekta.generics.middleearth;

public class MiddleEarthUnit extends Unit {
    @Override
    public Unit create(String typeOfUnit) {
        Unit unit = new MiddleEarthUnit();
        unit.setTypeOfUnit(typeOfUnit);
        return unit;
    }

    @Override
    public String toString() {
        return "MiddleEarth Unit " + getTypeOfUnit();
    }
}
