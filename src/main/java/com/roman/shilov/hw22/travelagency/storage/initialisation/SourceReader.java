package com.roman.shilov.hw22.travelagency.storage.initialisation;

@FunctionalInterface
public interface SourceReader<DATA> {
    DATA readDataFromFile(String filePath) throws Exception;
}
