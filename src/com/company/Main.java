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

        //while (true) {
        String countryName = console.nextLine();
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(countryName);
        if (matcher.find()) {
            countryName = countryName.toUpperCase();
        }

        Country result;
        try {
            result = Country.valueOf(countryName);
            if (result.getIsOpen()) {
                System.out.println("Страна " + result.toString() + " открыта для посещения.");
            } else {
                System.out.println("Страна " + result.toString() + " закрыта для посещения.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование страны на английском введено некорректно, проверяем русское название...");
            try {
                result = getByRuName(countryName);
                if (result.getIsOpen()) {
                    System.out.println("Страна " + result.toString() + " открыта для посещения.");
                } else {
                    System.out.println("Страна " + result.toString() + " закрыта для посещения.");
                }
            } catch (NoSuchCountryException ex) {
                System.out.println("Страны '" + countryName + "' не существует.");
            }
        } catch (NullPointerException e) {
            System.out.println("Неверный ввод! Попробуй еще раз ввести название страны...");
        }
    }
}