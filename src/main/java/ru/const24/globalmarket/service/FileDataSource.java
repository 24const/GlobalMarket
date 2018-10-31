package ru.const24.globalmarket.service;

import ru.const24.globalmarket.model.CurrencyNominal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Класс для получения данных о валюте из файлового источника данных
 */
public class FileDataSource implements CurrencyDataSource {

    private final String pathToFiles;

    public FileDataSource(String pathToFiles) {
        this.pathToFiles = pathToFiles;
    }

    private static final String COMMA_SEPARATOR = ",";

    @Override
    public CurrencyNominal getCurrencyNominalByDate(LocalDate date) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);

        String fileName = pathToFiles + File.separator + formattedDate + ".txt";

        try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {

            String[] currencyAsStringArray = fileStream.findFirst().get().split(COMMA_SEPARATOR);

            double unitUSD = Double.parseDouble(currencyAsStringArray[0]);
            double unitEUR = Double.parseDouble(currencyAsStringArray[1]);
            double unitRUB = Double.parseDouble(currencyAsStringArray[1]);

            CurrencyNominal returnNominal = new CurrencyNominal(unitUSD, unitEUR, unitRUB);

            return returnNominal;
        }
    }
}
