package com.intellekta.generics.middleearth;

public interface Unit {

    private String typeOfUnit;

    protected Unit create(String typeOfUnit) {
        return null;
    }
    protected String getTypeOfUnit() {
        return typeOfUnit;
    }

    protected void setTypeOfUnit(Unit typeOfUnit) {
        this.typeOfUnit = typeOfUnit;
    }
}
