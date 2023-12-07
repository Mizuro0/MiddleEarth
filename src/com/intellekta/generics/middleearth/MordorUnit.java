package com.intellekta.generics.middleearth;

public class MordorUnit extends Unit {


    @Override
    public Unit create(String typeOfUnit) {
        Unit unit = new MordorUnit();
        unit.setTypeOfUnit(typeOfUnit);
        return unit;
    }


    @Override
    public String toString() {
        return "Mordor Unit " + getTypeOfUnit();
    }

}
