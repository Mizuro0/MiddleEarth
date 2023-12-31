package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.ClassFinder;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.MiddleEarthUnit;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.MordorUnit;
import com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits.Unit;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry.HumanCavalry;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthCavalry.Wizard;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry.Elf;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry.HumanInfantry;
import com.intellekta.generics.middleearth.units.middleEarthUnits.middleEarthInfantry.WoodenElf;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorCavalry.OrcCavalry;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.Goblin;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.OrcInfantry;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.Troll;
import com.intellekta.generics.middleearth.units.mordorUnits.mordorInfantry.UrukHai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {

    private static Random random;
    private static final MordorUnit mordorUnit = new MordorUnit() {
    };
    private static final MiddleEarthUnit middleEarthUnit = new MiddleEarthUnit() {
    };


    public static void fight() throws IOException, ClassNotFoundException {

        List<Unit> mordorClasses = ClassFinder.findClasses("org.intellekta.generics.middleearth.units.mordorUnits");
        List<Unit> middleEarthClasses = ClassFinder.findClasses("org.intellekta.generics.middleearth.units.middleEarthUnits");

        Army<MordorUnit> mordorArmy = new Army<>(mordorUnit);
        Army<MiddleEarthUnit> middleEarthArmy = new Army<>(middleEarthUnit);

        int mordorArmyCount = random.nextInt((10 - 6 + 1) + 6);
        int middleEarthArmyCount = random.nextInt((((mordorArmyCount + 2) - (mordorArmyCount - 2) + 1) + (mordorArmyCount - 2)));

        for (int i = 0; i < mordorArmyCount; i++) {
            MordorUnit mordorUnit = (MordorUnit) createUnit(mordorClasses.get(random.nextInt(mordorClasses.size())));
            mordorArmy.recruit(mordorUnit);
        }
        for (int i = 0; i < middleEarthArmyCount; i++) {
            MiddleEarthUnit middleEarthUnit = (MiddleEarthUnit) createUnit(middleEarthClasses.get(random.nextInt(middleEarthClasses.size())));
            middleEarthArmy.recruit(middleEarthUnit);
        }

    }

    public static void fight(Army<?> firstArmy, Army<?> secondArmy) {


    }

    public static Unit createUnit(Unit unit) {
        Unit result = null;
        if (unit instanceof MordorUnit) {
            switch (unit.getClass().getSimpleName()) {
                case "Troll":
                    result = new Troll(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/trollNames"));
                    break;
                case "Goblin":
                    result = new Goblin(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/goblinNames"));
                    break;
                case "UrukHai":
                    result = new UrukHai(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/orcNames"));
                    break;
                case "OrcInfantry":
                    result = new OrcInfantry(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/orcNames"));
                    break;
                case "OrcCavalry":
                    result = new OrcCavalry(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/orcNames"));
                    break;
                default:
                    System.out.println("Incorrect type of unit");
            }
        } else if (unit instanceof MiddleEarthUnit) {
            switch (unit.getClass().getSimpleName()) {
                case "HumanCavalry":
                    result = new HumanCavalry(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/humanNames"));
                    break;
                case "HumanInfantry":
                    result = new HumanInfantry(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/humanNames"));
                    break;
                case "Wizard":
                    result = new Wizard(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/humanNames"));
                    break;
                case "Rohhirim":
                    result = new Wizard(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/humanNames"));
                    break;
                case "Elf":
                    result = new Elf(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/elfNames"));
                    break;
                case "WoodenElf":
                    result = new WoodenElf(nameForUnit("/Users/abdulahizriev/Documents/myJavaProject/src/namesForUnits/elfNames"));
            }

        }

        return result;
    }

    public static String nameForUnit(String filePath) {
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
    public static Army<? extends Unit> battleProcess(Army<?> firstArmy, Army<?> secondArmy) {

    }
}
