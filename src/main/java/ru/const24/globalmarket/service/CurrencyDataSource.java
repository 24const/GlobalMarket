package ru.const24.globalmarket.service;

import ru.const24.globalmarket.model.CurrencyNominal;

import java.time.LocalDate;

/**
 * TODO: add doc!
 */
public interface CurrencyDataSource {

    public CurrencyNominal getCurrencyNominalByDate(LocalDate date) throws Exception;
}
