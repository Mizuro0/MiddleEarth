package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.*;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry.HumanCavalry;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry.Rohhirim;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry.Wizard;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry.Elf;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry.HumanInfantry;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry.WoodenElf;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorCavalry.OrcCavalry;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.Goblin;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.OrcInfantry;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.Troll;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.UrukHai;
import org.testng.internal.collections.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {

    private static int minArmySize = 1000;
    private static int maxArmySize = 10000;

    private static int maxDifferencePercentage = 20;

    private static Random random = new Random();
    private static final MordorUnit mordorUnit = new MordorUnit() {
    };
    private static final MiddleEarthUnit middleEarthUnit = new MiddleEarthUnit() {
    };


    public static void fight() {

        List<Class<? extends Unit>> mordorClasses = null;
        List<Class<? extends Unit>> middleEarthClasses = null;
        try {
            mordorClasses = ClassFinder.findClasses("com.intellekta.generics.middleearth.units.mordorUnits");
            middleEarthClasses = ClassFinder.findClasses("com.intellekta.generics.middleearth.units.middleEarthUnits");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Army<MordorUnit> mordorArmy = new Army<>(mordorUnit);
        Army<MiddleEarthUnit> middleEarthArmy = new Army<>(middleEarthUnit);


        int mordorArmyCount = random.nextInt(maxArmySize - minArmySize + 1) + minArmySize;
        int middleEarthArmyCount;

        do {
            middleEarthArmyCount = generateRandomArmySize(minArmySize, maxArmySize);
        } while (Math.abs(mordorArmyCount - middleEarthArmyCount) > maxDifferencePercentage * 0.01 * maxArmySize);

        for (int i = 0; i < mordorArmyCount; i++) {
            Unit mordorUnit = createUnit(mordorClasses.get(random.nextInt(mordorClasses.size())));
            mordorArmy.recruit((MordorUnit) mordorUnit);
        }

        Class<?> wizard = Wizard.class;

        for (int i = 0; i < middleEarthArmyCount; i++) {
            Unit middleEarthUnit = createUnit(middleEarthClasses.get(random.nextInt(middleEarthClasses.size())));
            if (middleEarthArmy.getArmy().stream().anyMatch(wizard::isInstance) && middleEarthUnit instanceof Wizard) {
                while (middleEarthUnit instanceof Wizard) {
                    middleEarthUnit = createUnit(middleEarthClasses.get(random.nextInt(middleEarthClasses.size())));
                }
            }
            middleEarthArmy.recruit((MiddleEarthUnit) middleEarthUnit);
        }
        System.out.println(battleProcess(mordorArmy, middleEarthArmy));
    }

    public static void fight(Army<?> firstArmy, Army<?> secondArmy) {


    }

    private static Unit createUnit(Class<? extends Unit> unit) {
        String unitName = unit.getSimpleName();
        String path = "/Users/abdulahizriev/Documents/myJavaProject/src/com/intellekta/generics/middleearth/namesForUnits/";

        switch (unitName) {
            case "Troll":
                return new Troll(nameForUnit(path + "trollNames.txt"));
            case "Goblin":
                return new Goblin(nameForUnit(path + "goblinNames.txt"));
            case "UrukHai":
                return new UrukHai(nameForUnit(path + "orcNames.txt"));
            case "OrcInfantry":
                return new OrcInfantry(nameForUnit(path + "orcNames.txt"));
            case "OrcCavalry":
                return new OrcCavalry(nameForUnit(path + "orcNames.txt"));
            case "HumanCavalry":
                return new HumanCavalry(nameForUnit(path + "humanNames.txt"));
            case "HumanInfantry":
                return new HumanInfantry(nameForUnit(path + "humanNames.txt"));
            case "Wizard":
                return new Wizard(nameForUnit(path + "humanNames.txt"));
            case "Rohhirim":
                return new Rohhirim(nameForUnit(path + "humanNames.txt"));
            case "Elf":
                return new Elf(nameForUnit(path + "elfNames.txt"));
            case "WoodenElf":
                return new WoodenElf(nameForUnit(path + "elfNames.txt"));
            default:
                return null;
        }
    }

    private static String nameForUnit(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            List<String> namesList = new ArrayList<>();
            while (bufferedReader.ready()) {
                namesList.add(bufferedReader.readLine());
            }
            return namesList.get(random.nextInt(namesList.size()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> battleProcess(Army<MordorUnit> firstArmy, Army<MiddleEarthUnit> secondArmy) {
        Pair<Class<?>, List<?>> survivedCavalries = phases(firstArmy.getCavalry(), secondArmy.getCavalry());
        Pair<Class<?>, List<?>> survivedInfantries = phases(firstArmy.getInfantries(), secondArmy.getInfantries());
        Class<?> firstPhasesWinner = survivedCavalries.first();
        Class<?> secondPhasesWinner = survivedInfantries.first();
        Class<?> battleWinner = null;
        if (!firstPhasesWinner.equals(secondPhasesWinner)) {
            battleWinner = phases(survivedCavalries.second(), survivedInfantries.second()).first();
        }
        else {
            battleWinner = survivedCavalries.first();
        }
        return battleWinner;
    }

    private static Pair<Class<?>, List<?>> phases(List<?> units, List<?> otherUnits) {
        List<Object> survivingUnits = new ArrayList<>(units);
        List<Object> survivingOtherUnits = new ArrayList<>(otherUnits);

        while (!survivingUnits.isEmpty() && !survivingOtherUnits.isEmpty()) {
            Object unit1 = survivingUnits.get(random.nextInt(survivingUnits.size()));
            Object unit2 = survivingOtherUnits.get(random.nextInt(survivingOtherUnits.size()));

            int duelResult = duel((AbstractUnit) unit1, (AbstractUnit) unit2);
            if (duelResult == 2) {
                survivingUnits.remove(unit1);
            } else if (duelResult == 1) {
                survivingOtherUnits.remove(unit2);
            }
        }

        if (!survivingUnits.isEmpty()) {
            return new Pair<>(getUnitClass(units.get(0)), survivingUnits);
        } else {
            return new Pair<>(getUnitClass(otherUnits.get(0)), survivingOtherUnits);
        }
    }

    private static Class<?> getUnitClass(Object unit) {
        if (unit instanceof MordorUnit) {
            return MordorUnit.class;
        } else if (unit instanceof MiddleEarthUnit) {
            return MiddleEarthUnit.class;
        } else {
            throw new IllegalArgumentException("Unknown unit class: " + unit.getClass());
        }
    }

    private static int duel(AbstractUnit unit1, AbstractUnit unit2) {
        int result = random.nextInt(2) + 1;
        return result == 1 ? doDuelRound(unit1, unit2) : doDuelRound(unit2, unit1);
    }

    private static int doDuelRound(AbstractUnit attacker, AbstractUnit defender) {
        attacker.strike(defender);
        if (defender.isAlive()) {
            defender.strike(attacker);
            return attacker.isAlive() ? 3 : 2;
        } else {
            return 1;
        }
    }

    private static int generateRandomArmySize(int minSize, int maxSize) {
        return random.nextInt(maxSize - minSize + 1) + minSize;
    }

    public static void main(String[] args) {
        fight();
    }
}
