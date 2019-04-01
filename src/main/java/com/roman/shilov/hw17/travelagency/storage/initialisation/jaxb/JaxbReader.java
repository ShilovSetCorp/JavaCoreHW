package com.roman.shilov.hw17.travelagency.storage.initialisation.jaxb;

import com.roman.shilov.hw15.travelagency.storage.initialisation.jaxb.generatedclasses.CityJaxb;
import com.roman.shilov.hw15.travelagency.storage.initialisation.jaxb.generatedclasses.Country;
import com.roman.shilov.hw15.travelagency.storage.initialisation.jaxb.generatedclasses.InitData;
import com.roman.shilov.hw17.travelagency.cities.domain.City;
import com.roman.shilov.hw17.travelagency.common.solutions.utils.Months;
import com.roman.shilov.hw17.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw17.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw17.travelagency.countries.domain.CountryType;
import com.roman.shilov.hw17.travelagency.countries.domain.HotCountry;
import com.roman.shilov.hw17.travelagency.storage.initialisation.SourceReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbReader{// implements SourceReader<List<BaseCountry>> {
//    @Override


    public static List<BaseCountry> readDataFromFileViaLambda(String filePath) throws Exception {
        try {
            InitData dataFromXml = readDataFromXmlWithJaxb(filePath);
            return convertJaxbClassesToDomainClasses(dataFromXml);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("no such xml file");
        }
    }



    private static InitData readDataFromXmlWithJaxb(String filePath) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(InitData.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (InitData) jaxbUnmarshaller.unmarshal(new File(filePath));//JaxbReader.class.getResourceAsStream(filePath));
    }

    private static List<BaseCountry> convertJaxbClassesToDomainClasses(InitData dataFromXml) {
        List<BaseCountry> result = new ArrayList<>();

        List<Country> countries = dataFromXml.getCountries().getCountry();
        for(Country country : countries){
            result.add(convertJaxbCountryToDomainCountry(country));
        }
        return result;
    }

    private static BaseCountry convertJaxbCountryToDomainCountry(Country country) {
        BaseCountry domain;
        if(CountryType.HOT.name().equals(country.getType())){
            domain = toHotCountry(country);
        } else {
            domain = toColdCountry(country);
        }
        fillCommonCountryData(country, domain);
        return domain;
    }

    private static void fillCommonCountryData(Country country, BaseCountry domain) {
        domain.setName(country.getName());
        domain.setLanguage(country.getLanguage());
        domain.setTelephoneCode(country.getTelephoneCode());

        List<CityJaxb> cityJaxbs = country.getCities().getCityJaxb();
        if(!cityJaxbs.isEmpty()){
            domain.setCities(converjabxCitiesToDomainCities(cityJaxbs));
        }

    }

    private static List<City> converjabxCitiesToDomainCities(List<CityJaxb> cityJaxbs) {
        List<City> result = new ArrayList<>();

        for(CityJaxb cityJaxb: cityJaxbs) {
            result.add(converJabxCityToDomainCity(cityJaxb));
        }
        return result;
    }

    private static City converJabxCityToDomainCity(CityJaxb cityJaxb) {
        City city = new City();
        city.setName(cityJaxb.getName());
        city.setPopulation(cityJaxb.getPopulation());
        city.setCapital(cityJaxb.isIsCapital());
        return city;
    }

    private static ColdCountry toColdCountry(Country country) {
        ColdCountry coldCountry = new ColdCountry();
   //     fillCommonCountryData(country, coldCountry);
        coldCountry.setAverageSnowLevel(country.getAverageSnowLevel());
        coldCountry.setPolarNight(country.isPolarNight() != null);
        coldCountry.setTheMostSnowingMonth(Months.valueOf(country.getTheMostSnowingMonth()));
        return coldCountry;
    }

    private static HotCountry toHotCountry(Country country) {
        HotCountry hotCountry = new HotCountry();
        hotCountry.setAverageTemp(country.getAverageTemp());
        hotCountry.setHottestMonth(Months.valueOf(country.getHottestMonth()));
        return hotCountry;
    }


}
