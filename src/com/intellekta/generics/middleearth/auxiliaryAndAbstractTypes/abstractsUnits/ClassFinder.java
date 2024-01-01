package com.intellekta.generics.middleearth.auxiliaryAndAbstractTypes.abstractsUnits;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassFinder {

    public static List<Class<? extends Unit>> findClasses(String basePackage) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = basePackage.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);

        List<Class<? extends Unit>> unitClasses = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File directory = new File(resource.getFile());

            if (directory.exists()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            // Рекурсивный вызов для подпакетов
                            unitClasses.addAll(findClasses(basePackage + "." + file.getName()));
                        } else if (file.getName().endsWith(".class")) {
                            // Удаление расширения .class и добавление класса в список
                            String className = basePackage + '.' + file.getName().substring(0, file.getName().length() - 6);
                            Class<?> clazz = Class.forName(className);

                            // Проверка, является ли класс подклассом Unit
                            if (Unit.class.isAssignableFrom(clazz) && !clazz.equals(Unit.class)) {
                                unitClasses.add((Class<? extends Unit>) clazz);
                            }
                        }
                    }
                }
            }
        }

        return unitClasses;
    }
}