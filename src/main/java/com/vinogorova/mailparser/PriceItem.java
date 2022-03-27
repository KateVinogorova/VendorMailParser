package com.vinogorova.mailparser;

import com.opencsv.bean.CsvBindByPosition;

public class PriceItem {
    @CsvBindByPosition(position = 1)
    private String vendor;
    @CsvBindByPosition(position = 2)
    private String number;
    @CsvBindByPosition(position = 3)
    private String description;
    @CsvBindByPosition(position = 6)
    private String price;
    @CsvBindByPosition(position = 8)
    private String count;

    @Override
    public String toString() {
        return "Vendor: " + vendor + " | " + "number: " + number + " | " + "description: " + description + " | " +
                "price: " + price + " | " + "count: " + count;
    }
}
