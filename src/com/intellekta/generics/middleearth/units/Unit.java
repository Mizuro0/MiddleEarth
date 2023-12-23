package com.intellekta.generics.middleearth.units;

public interface Unit {

    <T> void strike(T t);
    String toString();
}
