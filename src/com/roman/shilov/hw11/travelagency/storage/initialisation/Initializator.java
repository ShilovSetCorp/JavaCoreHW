package com.roman.shilov.hw11.travelagency.storage.initialisation;

import com.roman.shilov.hw11.travelagency.cities.domain.City;
import com.roman.shilov.hw11.travelagency.cities.service.CityService;
import com.roman.shilov.hw11.travelagency.common.buisness.application.servicefactory.ServiceSupplier;
import com.roman.shilov.hw11.travelagency.common.solutions.utils.Months;
import com.roman.shilov.hw11.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw11.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw11.travelagency.countries.domain.HotCountry;
import com.roman.shilov.hw11.travelagency.countries.service.CountryService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Initializator {

    private static final String CITIES_COUNTRIES_PATH = "src\\resources\\InitCitiesAndCountries.txt";

    private static CountryService countryService = ServiceSupplier.setSupplier().getCountryService();
    private static CityService cityService = ServiceSupplier.setSupplier().getCityService();

    private static List<City> cities;


    public static void readerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(CITIES_COUNTRIES_PATH)))) {
            String s;
            while ((s = reader.readLine()) != null) {
                BaseCountry country = null;
                cities = new ArrayList<>();
                if ("country".equals(s)) {
                    s = reader.readLine();
                    country = parseCountryFromString(s);
                }

                String cityString;
                while ((cityString = reader.readLine()) != null && !"end country".equals(cityString)) {
                    parseCityFromString(cityString);
                }

                if (country != null) {
                    country.setCities(cities);
                    countryService.insert(country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BaseCountry parseCountryFromString(String s){
        String[] countryFields = s.split(" ");
        int attrIndex = -1;
        if ("hot".equals(countryFields[++attrIndex])) {
            return new HotCountry(countryFields[++attrIndex], countryFields[++attrIndex], countryFields[++attrIndex], Months.valueOf(countryFields[++attrIndex]), Integer.parseInt(countryFields[++attrIndex]));
        } else if ("cold".equals(countryFields[attrIndex])) {
            return new ColdCountry(countryFields[++attrIndex], countryFields[++attrIndex], countryFields[++attrIndex], Months.valueOf(countryFields[++attrIndex]), Integer.parseInt(countryFields[++attrIndex]), "polarnight".equals(countryFields[++attrIndex]));
        }
        return null;
    }

    private static void parseCityFromString(String s){
        int attrIndex = -1;
        City city = new City(s.split(" ")[++attrIndex], Integer.parseInt(s.split(" ")[++attrIndex].trim()), "capital".compareToIgnoreCase(s.split(" ")[++attrIndex]) == 0);
        cities.add(city);
        cityService.insert(city);
    }



}
