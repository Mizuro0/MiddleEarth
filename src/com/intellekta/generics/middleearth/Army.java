package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Cavalry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Infantry;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Army<U extends Unit> {

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
        return Stream.concat(cavalries.stream(), infantries.stream()).collect(Collectors.toList());
    }

    public boolean recruit(U unit) {
        try {
            if (unit instanceof Cavalry) {
                cavalries.add((Cavalry) unit);
                return true;
            } else if (unit instanceof Infantry) {
                infantries.add((Infantry) unit);
                return true;
            }
            return false;
        } catch (Exception ignored) {
            return false;
        }
    }

    public void print() {
        List<Unit> armyList = getArmy();
        for (int i = 0; i < armyList.size(); i++) {
            System.out.println(armyList.get(i).toString());
        }
    }

    public boolean realise(U unit) {
        try {
            if (unit instanceof Cavalry) {
                cavalries.remove(unit);
                return true;
            } else if (unit instanceof Infantry) {
                infantries.remove(0);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public Unit getRandomUnit() {
        List<Unit> armyList = getArmy();
        Random random = new Random();
        return armyList.get(random.nextInt(armyList.size()));
    }

    public Unit getRandomUnit(U unit) {
        Random random = new Random();
        if (unit instanceof Cavalry) {
            return cavalries.get(random.nextInt(cavalries.size()));
        } else if (unit instanceof Infantry) {
            return infantries.get(random.nextInt(infantries.size()));
        } else {
            return null;
        }
    }


}
