package com.intellekta.generics.middleearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army <U extends Unit>  {
    private final List<Cavalry> cavalries = new ArrayList<>();
    private final List<Infantry> infantries = new ArrayList<>();

    private U u;
    public Army(U u) {
        this.u = u;
    }

    private List<Unit> armyList = new ArrayList<>();

    public List<Unit> getCavalry() {
        return cavalries;
    }

    public List<Unit> getInfantries() {
        return infantries;
    }

    public List<Unit> getArmy() {
        return armyList;
    }

    public boolean recruit(U typeOfUnit) {
        try {
            Unit unit = u.create(typeOfUnit);
            if(unit.getTypeOfUnit().equalsIgnoreCase("Cavalry")) {
                cavalries.add(unit);
                armyList.add(0, unit);
            }
            else if (unit.getTypeOfUnit().equalsIgnoreCase("Infantry")) {
                infantries.add(unit);
                armyList.add(unit);
            }
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void print() {
        for(int i = 0; i < armyList.size(); i++) {
            System.out.println(armyList.get(i).toString());
        }
    }

    public boolean realise(Unit unit) {
        try {
            if(armyList.contains(unit)) {
                if(cavalries.contains(unit)) {
                    cavalries.remove(unit);
                }
                else {
                    infantries.remove(unit);
                }
                armyList.remove(unit);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Unit getRandomUnit() {
        Random random = new Random();
        return armyList.get(random.nextInt(armyList.size()));
    }

    public Unit getRandomUnit(String typeOfUnit) {
        Random random = new Random();
        if(typeOfUnit.equalsIgnoreCase("Cavalry")) {
            return cavalries.get(random.nextInt(cavalries.size()));
        }
        else if (typeOfUnit.equalsIgnoreCase("Infantry")) {
            return infantries.get(random.nextInt(infantries.size()));
        }
        else {
            return null;
        }
    }




}
