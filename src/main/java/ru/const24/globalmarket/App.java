package ru.const24.globalmarket;

import com.mashape.unirest.http.exceptions.UnirestException;
import ru.const24.globalmarket.model.Currency;
import ru.const24.globalmarket.model.CurrencyNominal;
import ru.const24.globalmarket.model.Money;
import ru.const24.globalmarket.service.CurrencyService;
import ru.const24.globalmarket.service.FileDataSource;
import ru.const24.globalmarket.service.Forge1DataSource;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {


        String currentFilePath = Paths.get("").toAbsolutePath().toString();
        CurrencyService currencyService = new CurrencyService(currentFilePath);

        Money myProduct = new Money(1, Currency.USD);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = localDate.format(dateTimeFormatter);

        Money exchangedMoney = currencyService.exchangeMoneyСurrencyByDate(myProduct, Currency.RUB, localDate);


        System.out.println("Date: " + dateString + " product costs: " + exchangedMoney);

    }
}
