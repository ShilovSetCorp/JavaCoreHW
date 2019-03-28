package com.roman.shilov.hw16.travelagency.storage.initialisation.sax;

import com.roman.shilov.hw16.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw16.travelagency.storage.initialisation.SourceReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class XmlSaxReader implements SourceReader<List<BaseCountry>> {
    @Override
    public List<BaseCountry> readDataFromFile(String filePath) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        CountrySaxHandler handler = new CountrySaxHandler();
        saxParser.parse(new File(filePath), handler);

        return handler.getCounties();
    }
}
