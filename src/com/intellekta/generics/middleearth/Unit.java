package com.intellekta.generics.middleearth;

public abstract class Unit {

    private String typeOfUnit;

    protected Unit create(String typeOfUnit) {
        return null;
    }
    protected String getTypeOfUnit() {
        return typeOfUnit;
    }

    protected void setTypeOfUnit(String typeOfUnit) {
        this.typeOfUnit = typeOfUnit;
    }
}
