package com.roman.shilov.hw12.travelagency.storage.initialisation;

public interface SourceReader<DATA> {
    DATA readDataFromFile(String filePath) throws Exception;
}
