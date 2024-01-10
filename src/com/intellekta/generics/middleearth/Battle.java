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
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Battle {

    private static int phaseN = 1;

    private static final String PHASE_START_MESSAGE = "Phase %d:";
    private static final String STRIKE_MESSAGE_FORMAT = "%s %s has power %d strikes %s %s has power %d and %s";
    private static final String KILLS_HIM = "kills him";
    private static final String DOES_NOT_KILL_HIM = "does not kill him";
    private static final String WINNERS_LIST_MESSAGE = "Army of %s has won the battle. The winners list:";


    private static int minArmySize = 3;
    private static int maxArmySize = 10;

    private static int maxDifferencePercentage = 20;

    private static Random random = new Random();
    private static final MordorUnit mordorUnit = new MordorUnit() {
    };
    private static final MiddleEarthUnit middleEarthUnit = new MiddleEarthUnit() {
    };


    public static void fight() throws ArmyMinSizeError {

        if (minArmySize <= 2) {
            System.out.println("Minimal size of army is incorrect, it must be more than 2!");
            throw new ArmyMinSizeError();
        }

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
        mordorArmy.recruit(new OrcInfantry("Feldgulg Moghtub"));
        mordorArmy.recruit(new OrcCavalry("Mash Rugomakh"));

        do {
            middleEarthArmyCount = generateRandomArmySize(minArmySize, maxArmySize);
        } while (Math.abs(mordorArmyCount - middleEarthArmyCount) > maxDifferencePercentage * 0.01 * maxArmySize && middleEarthArmyCount > 0);

        middleEarthArmy.recruit(new HumanInfantry("Peter Bethrinthafk"));
        middleEarthArmy.recruit(new HumanCavalry("Ezekiel Fonzenzur"));

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
        printArmy(mordorArmy);
        printArmy(middleEarthArmy);
        battleProcess(mordorArmy, middleEarthArmy);
    }

    public static void fight(Army<? extends Unit> firstArmy, Army<? extends Unit> secondArmy) throws ArmyMinSizeError {
        if(minArmySize <= 2) {
            throw new ArmyMinSizeError();
        }
        battleProcess(firstArmy, secondArmy);
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

    private static void battleProcess(Army<?> firstArmy, Army<?> secondArmy) {
        Pair<Class<?>, List<?>> survivedCavalries = phases(firstArmy.getCavalry(), secondArmy.getCavalry());
        Pair<Class<?>, List<?>> survivedInfantries = phases(firstArmy.getInfantries(), secondArmy.getInfantries());
        Pair<Class<?>, List<?>> thirdPhaseWinner;
        Class<?> firstPhasesWinner = survivedCavalries.first();
        Class<?> secondPhasesWinner = survivedInfantries.first();

        Pair<Class<?>, List<?>> battleWinner = null;
        List<AbstractUnit> survivedArmy = new ArrayList<>();
        if (!firstPhasesWinner.equals(secondPhasesWinner)) {
            battleWinner = phases(survivedCavalries.second(), survivedInfantries.second());
            survivedArmy = (List<AbstractUnit>) battleWinner.second();
        } else {
            survivedArmy.addAll((Collection<? extends AbstractUnit>) survivedCavalries.second());
            survivedArmy.addAll((Collection<? extends AbstractUnit>) survivedInfantries.second());
            battleWinner = new Pair<>(survivedCavalries.first(), survivedArmy);
        }
        System.out.printf(WINNERS_LIST_MESSAGE + "\n", battleWinner.first().getSimpleName());
        for (AbstractUnit u : survivedArmy) {
            System.out.printf("%s %s has power %d \n", u.getClass().getSimpleName(), u.getName(), u.getPower());
        }
    }

    private static Pair<Class<?>, List<?>> phases(List<?> units, List<?> otherUnits) {
        System.out.printf(PHASE_START_MESSAGE + "\n", phaseN++);
        if (units.isEmpty()) {
            if (otherUnits.isEmpty()) {
                return null;
            } else return new Pair<>(getUnitClass(otherUnits.get(0)), otherUnits);
        } else if (otherUnits.isEmpty()) {
            return new Pair<>(getUnitClass(units.get(0)), units);
        }
        List<Object> survivingUnits = null;
        List<Object> survivingOtherUnits = null;
        if(units.get(0) instanceof MordorUnit) {
            survivingUnits = new ArrayList<>(units);
            survivingOtherUnits = new ArrayList<>(otherUnits);
        }
        else if (units.get(0) instanceof MiddleEarthUnit) {
            survivingUnits = new ArrayList<>(otherUnits);
            survivingOtherUnits = new ArrayList<>(units);
        }

        while (!survivingUnits.isEmpty() && !survivingOtherUnits.isEmpty()) {
            AbstractUnit unit1 = (AbstractUnit) survivingUnits.get(random.nextInt(survivingUnits.size()));
            AbstractUnit unit2 = (AbstractUnit) survivingOtherUnits.get(random.nextInt(survivingOtherUnits.size()));

            AbstractUnit duelWinner = duel(unit1, unit2);
            if (duelWinner instanceof MiddleEarthUnit) {
                survivingUnits.remove(unit1);
            } else if (duelWinner instanceof MordorUnit) {
                survivingOtherUnits.remove(unit2);
            }
        }

        if (!survivingUnits.isEmpty()) {
            return new Pair<>(getUnitClass(survivingUnits.get(0)), survivingUnits);
        } else {
            return new Pair<>(getUnitClass(survivingOtherUnits.get(0)), survivingOtherUnits);
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

    private static AbstractUnit duel(AbstractUnit attacker, AbstractUnit defender) {
        int result = random.nextInt(2) + 1;
        if (result == 1) {
            return doDuelRound(attacker, defender);
        } else {
            return doDuelRound(defender, attacker);
        }
    }

    private static AbstractUnit doDuelRound(AbstractUnit attacker, AbstractUnit defender) {
        int defendersPowerBeforeStrike = defender.getPower();
        int attackersPowerBeforeStrike = attacker.getPower();
        AbstractUnit winner;
        attacker.strike(defender);
        if (defender.isAlive()) {
            System.out.printf(STRIKE_MESSAGE_FORMAT + "\n", attacker.getClass().getSimpleName(), attacker.getName(), attacker.getPower(), defender.getClass().getSimpleName(), defender.getName(), defendersPowerBeforeStrike, DOES_NOT_KILL_HIM);
            defender.strike(attacker);
            if (attacker.isAlive()) {
                System.out.printf(STRIKE_MESSAGE_FORMAT + "\n", defender.getClass().getSimpleName(), defender.getName(), defender.getPower(), attacker.getClass().getSimpleName(), attacker.getName(), attackersPowerBeforeStrike, DOES_NOT_KILL_HIM);
                winner = null;
            } else {
                System.out.printf(STRIKE_MESSAGE_FORMAT + "\n", defender.getClass().getSimpleName(), defender.getName(), defender.getPower(), attacker.getClass().getSimpleName(), attacker.getName(), attackersPowerBeforeStrike, KILLS_HIM);
                winner = defender;
            }
        } else {
            System.out.printf(STRIKE_MESSAGE_FORMAT + "\n", attacker.getClass().getSimpleName(), attacker.getName(), attacker.getPower(), defender.getClass().getSimpleName(), defender.getName(), defendersPowerBeforeStrike, KILLS_HIM);
            winner = attacker;
        }
        return winner;
    }

    private static int generateRandomArmySize(int minSize, int maxSize) {
        return random.nextInt(maxSize - minSize + 1) + minSize;
    }

    private static void printArmy(Army<?> army) {
        String armyType = null;
        if (army.getArmy().get(0) instanceof MordorUnit) armyType = "Mordor";
        else if (army.getArmy().get(0) instanceof MiddleEarthUnit) armyType = "Middle Earth";
        System.out.printf("Army of %s consist of: \n", armyType);
        for (int i = 0; i < army.getArmy().size(); i++) {
            AbstractUnit unit = (AbstractUnit) army.getArmy().get(i);
            System.out.printf("%s %s has power %d \n", unit.getClass().getSimpleName(), unit.getName(), unit.getPower());
        }
    }

    public static void main(String[] args) throws ArmyMinSizeError {
        fight();
    }
}
