package com.roman.shilov.hw12.travelagency.storage.initialisation;

import com.roman.shilov.hw12.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw12.travelagency.countries.service.CountryService;

import java.util.ArrayList;
import java.util.List;

public class Initializator {

    public enum DataSourceType {
        TXT_FILE, XML_FILE, JSON_FILE
    }

    private CountryService countryService;

    public Initializator(CountryService countryService) {
        this.countryService = countryService;
    }

    public void initCountriesAndCities(String filePath, DataSourceType sourceType) throws Exception {
        SourceReader<List<BaseCountry>> sourceReader = null;
        List<BaseCountry> coutries = new ArrayList<>();

        switch (sourceType) {
            case TXT_FILE: {
                sourceReader = new TxtReader();
                break;
            }

            case XML_FILE: {
                sourceReader = new XmlReader();
                break;
            }

            case JSON_FILE: {
                break;
            }
        }

        if (sourceReader != null) {
            coutries = sourceReader.readDataFromFile(filePath);
        }

        for (BaseCountry country : coutries) {
            countryService.insert(country);
        }
    }

}
