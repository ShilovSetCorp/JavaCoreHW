package com.roman.shilov.hw22.travelagency.storage.initialisation.sax;

import com.roman.shilov.hw22.travelagency.cities.domain.City;
import com.roman.shilov.hw22.travelagency.common.solutions.utils.Months;
import com.roman.shilov.hw22.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw22.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw22.travelagency.countries.domain.CountryType;
import com.roman.shilov.hw22.travelagency.countries.domain.HotCountry;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountrySaxHandler extends DefaultHandler {

    private List<BaseCountry> countries;
    private BaseCountry country;
    private City city;
    private StringBuilder stringBuilder = new StringBuilder();
    private String type;

    private Stack<String> path = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        path.push(qName);

        switch (qName) {

            case "countries": {
                countries = new ArrayList<>();
                break;
            }

            case "country": {
                type = attributes.getValue("type");
                if(CountryType.isTypeExists(type)){
                    if(type.equals(CountryType.HOT.name())){
                        country = new HotCountry();
                    }else {
                        country = new ColdCountry();
                    }
                }
                break;
            }

            case "cities": {
                country.setCities(new ArrayList<>());
                break;
            }

            case "city": {
                city = new City();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        path.pop();

        switch (qName){

            case "country": {

                countries.add(country);
                break;
            }

            case "name": {
                String data = stringBuilder.toString();
                if(path.peek().equals("country")){
                    country.setName(data);
                }else {
                    city.setName(data);
                }
                stringBuilder.setLength(0);
                break;
            }

            case "language": {
                country.setLanguage(stringBuilder.toString());
                stringBuilder.setLength(0);
                break;
            }

            case "telephoneCode": {
                country.setTelephoneCode(stringBuilder.toString());
                stringBuilder.setLength(0);
                break;
            }

            case "month": {
                if(country.getType().equals(CountryType.HOT)){
                    ((HotCountry)country).setHottestMonth(Months.valueOf(stringBuilder.toString()));
                }else {
                    ((ColdCountry)country).setTheMostSnowingMonth(Months.valueOf(stringBuilder.toString()));
                }
                stringBuilder.setLength(0);
                break;
            }

            case "average": {
                if(country.getType().equals(CountryType.HOT)){
                    ((HotCountry)country).setAverageTemp(Integer.parseInt(stringBuilder.toString()));
                }else {
                    ((ColdCountry)country).setAverageSnowLevel(Integer.parseInt(stringBuilder.toString()));
                }
                stringBuilder.setLength(0);
                break;
            }

            case "polarnight": {
                if(country.getType().equals(CountryType.COLD)){
                    ((ColdCountry)country).setPolarNight("polarnight".equals(stringBuilder.toString()));
                }
                stringBuilder.setLength(0);
                break;
            }

            case "population": {
                city.setPopulation(Integer.parseInt(stringBuilder.toString()));
                stringBuilder.setLength(0);
                break;
            }

            case "iscapital": {
                city.setCapital("capital".equals(stringBuilder.toString()));
                stringBuilder.setLength(0);
                break;
            }

            case "city": {
                country.getCities().add(city);
                stringBuilder.setLength(0);
                break;
            }

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data.trim());
    }

    public List<BaseCountry> getCounties() {
        return countries;
    }
}
