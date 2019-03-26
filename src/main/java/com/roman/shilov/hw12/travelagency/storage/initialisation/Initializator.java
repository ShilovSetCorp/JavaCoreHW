package com.roman.shilov.hw12.travelagency.storage.initialisation;

import com.roman.shilov.hw12.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw12.travelagency.countries.service.CountryService;
import com.roman.shilov.hw12.travelagency.storage.initialisation.sax.XmlSaxReader;
import com.roman.shilov.hw12.travelagency.storage.initialisation.stax.XmlStaxReader;

import java.util.ArrayList;
import java.util.List;

public class Initializator {

    public enum DataSourceType {
        TXT_FILE, XML_FILE, JSON_FILE
    }

    public enum ParserType {
        DOM, SAX, STAX
    }

    private CountryService countryService;

    public Initializator(CountryService countryService) {
        this.countryService = countryService;
    }

    public void initCountriesAndCities(String filePath, DataSourceType sourceType) throws Exception {
        SourceReader<List<BaseCountry>> sourceReader = null;
        List<BaseCountry> coutries = new ArrayList<>();
        ParserType parserType = ParserType.STAX;

        switch (sourceType) {
            case TXT_FILE: {
                sourceReader = new TxtReader();
                break;
            }

            case XML_FILE: {
                switch (parserType){
                    case DOM: {
                        sourceReader = new XmlReader();
                        break;
                    }
                    case SAX: {
                        sourceReader = new XmlSaxReader();
                        break;
                    }
                    case STAX:{
                        sourceReader = new XmlStaxReader();
                        break;
                    }
                }
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
