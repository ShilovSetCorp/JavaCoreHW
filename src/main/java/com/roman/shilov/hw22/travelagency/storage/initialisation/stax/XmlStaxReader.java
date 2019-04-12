package com.roman.shilov.hw22.travelagency.storage.initialisation.stax;

import com.roman.shilov.hw22.travelagency.cities.domain.City;
import com.roman.shilov.hw22.travelagency.common.solutions.utils.Months;
import com.roman.shilov.hw22.travelagency.common.solutions.utils.xml.stax.CustomStaxReader;
import com.roman.shilov.hw22.travelagency.common.solutions.utils.xml.stax.XmlStaxUtils;
import com.roman.shilov.hw22.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw22.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw22.travelagency.countries.domain.CountryType;
import com.roman.shilov.hw22.travelagency.countries.domain.HotCountry;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XmlStaxReader{ //implements SourceReader<List<BaseCountry>> {
   // @Override
    public static List<BaseCountry> readDataFromFileViaLambda(String filePath) throws Exception {
        try (CustomStaxReader staxReader = CustomStaxReader.newInstance(filePath)){
            return readDocument(staxReader.getReader());
        }
    }

    private static List<BaseCountry> readDocument(XMLStreamReader reader) throws XMLStreamException{
        while (reader.hasNext()){
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();

                    if("countries".equals(elementName)) {
                        return readCountries(reader);
                    }
                    break;
                }
                case XMLStreamReader.END_ELEMENT: {
                    String elemName = reader.getLocalName();
                    System.out.println("End elem " + elemName);
                    break;
                }
            }
        }
        throw new RuntimeException("oops");
    }

    private static List<BaseCountry> readCountries(XMLStreamReader reader) throws XMLStreamException{
        List<BaseCountry> countries = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();
                    if ("country".equals(elementName)) {
                        countries.add(readCountry(reader));
                    }
                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return countries;
                }
            }
        }
        throw new RuntimeException("oops");
    }

    private static BaseCountry readCountry(XMLStreamReader reader) throws XMLStreamException {
        BaseCountry country = null;
        CountryType type = CountryType.valueOf(reader.getAttributeValue(null, "type"));
        if (type.equals(CountryType.COLD)) {
            country = new ColdCountry();
        } else if (type.equals(CountryType.HOT)) {
            country = new HotCountry();
        }

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();
                    if ("name".equals(elementName)) {
                        country.setName(XmlStaxUtils.readContentBetweenTags(reader));
                    } else if ("language".equals(elementName)) {
                        country.setLanguage(XmlStaxUtils.readContentBetweenTags(reader));
                    } else if ("telephoneCode".equals(elementName)) {
                        country.setTelephoneCode(XmlStaxUtils.readContentBetweenTags(reader));
                    } else if ("month".equals(elementName)) {
                        if (country.getType().equals(CountryType.HOT)) {
                            ((HotCountry) country).setHottestMonth(Months.valueOf(XmlStaxUtils.readContentBetweenTags(reader)));
                        } else {
                            ((ColdCountry) country).setTheMostSnowingMonth(Months.valueOf(XmlStaxUtils.readContentBetweenTags(reader)));
                        }
                    } else if ("average".equals(elementName)) {
                        if (country.getType().equals(CountryType.HOT)) {
                            ((HotCountry) country).setAverageTemp(Integer.parseInt(XmlStaxUtils.readContentBetweenTags(reader)));
                        } else {
                            ((ColdCountry) country).setAverageSnowLevel(Integer.parseInt(XmlStaxUtils.readContentBetweenTags(reader)));
                        }
                    } else if ("polarnight".equals(elementName)) {
                        if (country.getType().equals(CountryType.COLD)) {
                            ((ColdCountry) country).setPolarNight("polarnight".equals(XmlStaxUtils.readContentBetweenTags(reader)));
                        }
                    } else if ("cities".equals(elementName)) {
                        country.setCities(readCities(reader));
                    }
                    break;
                }

                case XMLStreamReader.END_ELEMENT: {
                    return country;
                }
            }
        }
        throw new RuntimeException("oops");
    }

    private static List<City> readCities(XMLStreamReader reader) throws XMLStreamException{
        List<City> cities = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();

                    if ("city".equals(elementName)) {
                        cities.add(readCity(reader));
                    }
                    break;
                }
                case XMLStreamReader.END_ELEMENT: {
                    return cities;
                }
            }
        }
        throw new RuntimeException("oops");
    }

    private static City readCity(XMLStreamReader reader) throws XMLStreamException{
        City city = new City();

        while (reader.hasNext()) {
            int eventType = reader.next();

            switch (eventType) {
                case XMLStreamReader.START_ELEMENT: {
                    String elementName = reader.getLocalName();

                    if ("name".equals(elementName)) {
                        city.setName(XmlStaxUtils.readContentBetweenTags(reader));
                    } else if ("population".equals(elementName)) {
                        city.setPopulation(Integer.parseInt(XmlStaxUtils.readContentBetweenTags(reader)));
                    } else if ("iscapital".equals(elementName)) {
                        city.setCapital("capital".equals(XmlStaxUtils.readContentBetweenTags(reader)));
                    }
                    break;
                }
                case XMLStreamReader.END_ELEMENT: {
                    return city;
                }
            }
        }
        throw new RuntimeException("oops");
    }
}
