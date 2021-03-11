package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.Country.getByRuName;

public class Main {
    public static void main(final String[] args) {
        Scanner console = new Scanner(System.in);

        for (Country country : Country.values()) {
            System.out.println(country.toString());
        }

        System.out.print("Введи название страны на английском: ");

        String countryName = console.nextLine();
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(countryName);
        if (matcher.find()) {
            countryName = countryName.toUpperCase();
        }

        Country userCountry;
        try {
            userCountry = Country.valueOf(countryName);
            checkIsOpen(userCountry);
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
            try {
                userCountry = getByRuName(countryName);
                checkIsOpen(userCountry);
            } catch (NoSuchCountryException ex) {
                System.out.println("Страны '" + countryName + "' не существует.");
            }
        } catch (NullPointerException e) {
            System.out.println("Ошибка при выполнении программы.");
        }
    }

    private static void checkIsOpen(final Country country) {
        if (country.getIsOpen()) {
            System.out.println("Страна [" + country.toString() + "] открыта для посещения.");
        } else {
            System.out.println("Страна [" + country.toString() + "] закрыта для посещения.");
        }
    }
}