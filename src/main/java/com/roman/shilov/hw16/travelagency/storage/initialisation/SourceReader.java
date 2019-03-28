package com.roman.shilov.hw16.travelagency.storage.initialisation;

public interface SourceReader<DATA> {
    DATA readDataFromFile(String filePath) throws Exception;
}
