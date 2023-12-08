package com.intellekta.generics.middleearth;

<<<<<<< HEAD
public interface MiddleEarthUnit extends Unit {
=======
public class MiddleEarthUnit extends Unit {
    @Override
    public Unit create(String typeOfUnit) {
        Unit unit = new MiddleEarthUnit();
        unit.setTypeOfUnit(typeOfUnit);
        return unit;
    }
>>>>>>> master


}
