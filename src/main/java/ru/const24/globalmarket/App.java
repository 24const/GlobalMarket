package ru.const24.globalmarket;

import com.mashape.unirest.http.exceptions.UnirestException;
import ru.const24.globalmarket.model.CurrencyNominal;
import ru.const24.globalmarket.service.FileDataSource;
import ru.const24.globalmarket.service.Forge1DataSource;

import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        Forge1DataSource forge1DataSource = new Forge1DataSource();
        CurrencyNominal forge1Nominal = forge1DataSource.getCurrencyNominalByDate(LocalDate.now());

        String currentFilePath = Paths.get("").toAbsolutePath().toString();

        System.out.println("currentFilePath: " + currentFilePath);
        FileDataSource fileDataSource = new FileDataSource(currentFilePath);

        CurrencyNominal fileNominal = fileDataSource.getCurrencyNominalByDate(LocalDate.now());

        System.out.println("forge1Nominal: " + forge1Nominal);
        System.out.println("fileNominal: " + fileNominal);

    }
}
