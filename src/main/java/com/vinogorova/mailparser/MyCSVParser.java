package com.vinogorova.mailparser;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MyCSVParser {
    private static List<PriceItem> priceItems;

    public List<PriceItem> parseToList(File file) {
        try {
            return priceItems = new CsvToBeanBuilder<PriceItem>(new FileReader(file))
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .withSkipLines(1)
                    .withType(PriceItem.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return priceItems;
    }

    public List<PriceItem> getPriceAsList() {
        return priceItems;
    }
}
