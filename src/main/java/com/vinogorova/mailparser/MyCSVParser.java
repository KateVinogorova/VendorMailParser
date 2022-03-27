package com.vinogorova.mailparser;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MyCSVParser {
    private static List<PriceItem> priceItems;

    public static void parseToList(File file) {
        try {
            priceItems = new CsvToBeanBuilder<PriceItem>(new FileReader(file))
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .withSkipLines(1)
                    .withType(PriceItem.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<PriceItem> getPriceAsList() {
        return priceItems;
    }
}
