package com.roman.shilov.hw16.travelagency.storage.initialisation;

import com.roman.shilov.hw16.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw16.travelagency.countries.service.CountryService;
import com.roman.shilov.hw16.travelagency.storage.initialisation.jaxb.JaxbReader;
import com.roman.shilov.hw16.travelagency.storage.initialisation.sax.XmlSaxReader;
import com.roman.shilov.hw16.travelagency.storage.initialisation.stax.XmlStaxReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Initializator {

    public enum DataSourceType {
        TXT_FILE, XML_FILE, JSON_FILE
    }

    public enum ParserType {
        DOM, SAX, STAX, JAXB
    }

    private CountryService countryService;


    public Initializator(CountryService countryService) {
        this.countryService = countryService;
    }

    public void concurrentInit(DataSourceType type, String path1, String path2){
        InitThread thread1 = new InitThread(path1, type);
        InitThread thread2 = new InitThread(path2, type);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        for (BaseCountry c: thread1.getCountries()) {
            countryService.insert(c);
        }
        for (BaseCountry c: thread2.getCountries() ) {
            countryService.insert(c);
        }
    }



    private static class InitThread implements Runnable{
        private String filePath;
        private DataSourceType type;
        private List<BaseCountry> countries = new ArrayList<>();
        private Thread thread;

        public InitThread(String filePath, DataSourceType type) {
            this.filePath = filePath;
            this.type = type;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            try {
                countries = Initializator.initCountriesAndCities(filePath, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void start(){
            thread.start();
        }

        public void join() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public List<BaseCountry> getCountries() {
            return countries;
        }
    }

    public static List<BaseCountry> initCountriesAndCities(String filePath, DataSourceType sourceType) throws Exception {
        SourceReader<List<BaseCountry>> sourceReader = null;
        ParserType parserType = ParserType.JAXB;
        List<BaseCountry> countries = new ArrayList<>();
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
                    case JAXB: {
                        sourceReader = new JaxbReader();
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
            countries = sourceReader.readDataFromFile(filePath);
        }

        return countries;
    }

}
