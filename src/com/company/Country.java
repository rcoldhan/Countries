package com.company;

public enum Country {

    RUSSIA,
    UAE,
    USA,
    HUNGARY,
    NORWAY,
    UKRAINE,
    SPAIN;

    private final String ruName;
    boolean isOpen;

    Country(String ruName, boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return Country + " ("
                + ruName + ")";
    }

    static Country getByRuName(Country countries) {}
}
