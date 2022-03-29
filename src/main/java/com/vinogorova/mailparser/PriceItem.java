package com.vinogorova.mailparser;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PriceItems")
public class PriceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private long id;

    @Column(name = "Vendor", length = 64)
    @CsvBindByPosition(position = 1)
    private String vendor;

    @Column(name = "Number", length = 64)
    @CsvBindByPosition(position = 10)
    private String number;

    @Column(name = "Description", length = 512)
    @CsvBindByPosition(position = 3)
    private String description;

    @CsvBindByPosition(position = 6)
    @Column(name = "Price")
    private double price;

    @CsvBindByPosition(position = 8)
    @Column(name = "Count")
    private int count;

//    public long getId() {
//        return id;
//    }
//
//    public String getVendor() {
//        return vendor;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getCount() {
//        return count;
//    }

    public PriceItem() {
    }

    public PriceItem(String vendor, String number, String description, double price, int count) {
        this.vendor = vendor;
        this.number = number;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, number, description, price, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceItem priceItem = (PriceItem) o;
        return Objects.equals(vendor, priceItem.vendor) &&
                Objects.equals(number, priceItem.number) &&
                Objects.equals(description, priceItem.description) &&
                Objects.equals(price, priceItem.price) &&
                Objects.equals(count, priceItem.count);
    }

    @Override
    public String toString() {
        return "Vendor: " + vendor + " | " + "number: " + number + " | " + "description: " + description + " | " +
                "price: " + price + " | " + "count: " + count;
    }
}
