package com.company;

public enum Country {

    RUSSIA("Россия", true),
    UAE("Объединенные Арабские Эмираты", true),
    USA("Соединенные Штаты Америки", true),
    HUNGARY("Венгрия", false),
    NORWAY("Норвегия", false),
    UKRAINE("Украина", false),
    SPAIN("Испания", false);

    private final String ruName;
    private final boolean isOpen;

    public boolean getIsOpen() {
        return isOpen;
    }

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return name() + " (" + ruName + ")";
    }

    static Country getByRuName(final String input) throws NoSuchCountryException {
        for (Country country : Country.values()) {
            if (input.equalsIgnoreCase(country.ruName)) {
                return country;
            }
        }
        throw new NoSuchCountryException();
    }
}