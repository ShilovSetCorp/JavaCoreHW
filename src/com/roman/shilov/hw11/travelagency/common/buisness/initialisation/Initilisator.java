package com.roman.shilov.hw11.travelagency.common.buisness.initialisation;

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

public class Initilisator {

    private static final String CITIES_COUNTRIES_PATH = "C:\\Users\\RomanSES\\epam\\src\\resources\\InitCitiesAndCountries.txt";//"src\\com\\roman\\shilov\\resources\\InitCitiesAndCountries.txt";


    private static CountryService countryService = ServiceSupplier.setSupplier().getCountryService();
    private static CityService cityService = ServiceSupplier.setSupplier().getCityService();



    public static void readerFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(CITIES_COUNTRIES_PATH)))) {
            String s;
            while ((s = reader.readLine()) != null){
                BaseCountry country = null;
                List<City> cities = new ArrayList<>();
                if("country".equals(s)){
                    String[] countryFields = reader.readLine().split(" ");

                    if("hot".equals(countryFields[0])) {
                        country = new HotCountry(countryFields[1], countryFields[2], countryFields[3], Months.valueOf(countryFields[4]), Integer.parseInt(countryFields[5]));
                    }else if("cold".equals(countryFields[0])){
                        country = new ColdCountry(countryFields[1], countryFields[2], countryFields[3], Months.valueOf(countryFields[4]), Integer.parseInt(countryFields[5]));
                    }
                }
                String cityString;
                while ((cityString = reader.readLine()) != null && !"end country".equals(cityString)){
                    City city = new City(cityString.split(" ")[0], Integer.parseInt(cityString.split(" ")[1]), "capital".compareToIgnoreCase(cityString.split(" ")[2])==0);
                    cities.add(city);
                    cityService.insert(city);
                }

                if(country != null) {
                    country.setCities(cities);
                    countryService.insert(country);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
