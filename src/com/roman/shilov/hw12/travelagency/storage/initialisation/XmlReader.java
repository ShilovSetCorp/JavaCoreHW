package com.roman.shilov.hw12.travelagency.storage.initialisation;

import com.roman.shilov.hw12.travelagency.cities.domain.City;
import com.roman.shilov.hw12.travelagency.common.solutions.utils.Months;
import com.roman.shilov.hw12.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw12.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw12.travelagency.countries.domain.HotCountry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements SourceReader<List<BaseCountry>> {

    @Override
    public List<BaseCountry> readDataFromFile(String filePath) throws Exception {
        if(!new File(filePath).exists() || new File(filePath).isDirectory()){
            throw new Exception("No such file");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));

        Node root = document.getElementsByTagName("countries").item(0);
        NodeList countries = ((Element)root).getElementsByTagName("country");

        List<BaseCountry> parsedCountries = new ArrayList<>();
        if(countries.getLength() > 0){
            for (int i = 0; i < countries.getLength(); i++) {

                Node xmlCountry = countries.item(i);
                NodeList countryInnerTags = xmlCountry.getChildNodes();
                NodeList coutryDescriptorTag = ((Element)countryInnerTags).getElementsByTagName("descriptor");
                BaseCountry country = null;
                //descriptor checking
                if("hot".equals(coutryDescriptorTag.item(0).getTextContent())){
                    country = new HotCountry();
                }else if("cold".equals(coutryDescriptorTag.item(0).getTextContent())){
                    country = new ColdCountry();
                }
                if(country != null){
                    parsedCountries.add(country);
                    fillCountryFields(country, countryInnerTags);
                }
            }
        }
        return parsedCountries;
    }

    private void fillCountryFields(BaseCountry country, NodeList countryInnerTags){
        for (int j = 1; j < countryInnerTags.getLength(); j++) {
            Node countryInner = countryInnerTags.item(j);
            switch (countryInner.getNodeName()){
                case "name": {
                    country.setName(countryInner.getTextContent());
                    break;
                }
                case "language": {
                    country.setLanguage(countryInner.getTextContent());
                    break;
                }
                case "telephoneCode": {
                    country.setTelephoneCode(countryInner.getTextContent());
                    break;
                }
                case "month": {
                    if(country instanceof HotCountry){
                        ((HotCountry)country).setHottestMonth(Months.valueOf(countryInner.getTextContent()));
                    }else {
                        ((ColdCountry)country).setTheMostSnowingMonth(Months.valueOf(countryInner.getTextContent()));
                    }
                    break;
                }
                case "polarnight": {
                    if(country instanceof ColdCountry) {
                        ((ColdCountry) country).setPolarNight("polarnight".equals(countryInner.getTextContent()));
                    }
                    break;
                }
                case "average":{
                    if(country instanceof HotCountry){
                        ((HotCountry)country).setAverageTemp(Integer.parseInt(countryInner.getTextContent()));
                    }else {
                        ((ColdCountry)country).setAverageSnowLevel(Integer.parseInt(countryInner.getTextContent()));
                    }
                    break;
                }
                case "cities": {
                    addCitiesToCountry(country, countryInner);
                    break;
                }
            }
        }
    }

    private void addCitiesToCountry(BaseCountry country, Node countryInner){
        country.setCities(new ArrayList<>());

        NodeList xmlCities = ((Element) countryInner).getElementsByTagName("city");

        for (int k = 0; k < xmlCities.getLength(); k++) {
            Element xmlCity = (Element) xmlCities.item(k);

            City city = new City();
            country.getCities().add(city);

            city.setName(xmlCity.getElementsByTagName("name").item(0).getTextContent());
            city.setPopulation(Integer.parseInt(xmlCity.getElementsByTagName("population").item(0).getTextContent()));
            city.setCapital("capital".equals(xmlCity.getElementsByTagName("iscapital").item(0).getTextContent()));
        }
    }
}


