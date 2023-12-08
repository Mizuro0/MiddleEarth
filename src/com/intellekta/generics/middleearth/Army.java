package com.intellekta.generics.middleearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army <U extends Unit>  {

    private final List<Unit> armyList = new ArrayList<>();
    private final List<Cavalry> cavalries = new ArrayList<>();
    private final List<Infantry> infantries = new ArrayList<>();

    private U u;
    public Army(U u) {
        this.u = u;
    }


    public List<Cavalry> getCavalry() {
        return cavalries;
    }

    public List<Infantry> getInfantries() {
        return infantries;
    }

    public List<Unit> getArmy() {
        return armyList;
    }

    public  boolean recruit(TypeOfUnit typeOfUnit) {
        try {

            if(typeOfUnit instanceof Cavalry) {
                Cavalry cavalry = new Cavalry() {
                    @Override
                    public String toString() {
                        if (u instanceof MiddleEarthUnit) {
                            return "Middle Earth Cavalry";
                        }
                        else if (u instanceof MordorUnit) {
                            return "Mordor Cavalry";
                        }
                        else {
                            return null;
                        }
                    }
                };
                cavalries.add(cavalry);
                armyList.add(0, cavalry);
            }
            else if (typeOfUnit instanceof Infantry) {
                Infantry infantry = new Infantry() {
                    @Override
                    public String toString() {
                        if (u instanceof MiddleEarthUnit) {
                            return "Middle Earth Infantry";
                        }
                        else if (u instanceof MordorUnit) {
                            return "Mordor Infantry";
                        }
                        else {
                            return null;
                        }
                    }
                };
                infantries.add(infantry);
                armyList.add(infantry);
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

    public boolean realise(TypeOfUnit unit) {
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

    public Unit getRandomUnit(TypeOfUnit typeOfUnit) {
        Random random = new Random();
        if(typeOfUnit instanceof Cavalry) {
            return cavalries.get(random.nextInt(cavalries.size()));
        }
        else if (typeOfUnit instanceof Infantry) {
            return infantries.get(random.nextInt(infantries.size()));
        }
        else {
            return null;
        }
    }




}
