package com.vinogorova.mailparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyCSVParserTest {
    private static final File DIR = new File("src/main/resources/price.csv");
    private MyCSVParser myCSVParser;
    private List<PriceItem> list;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myCSVParser = new MyCSVParser();
        list = new ArrayList<>();
        list.add(new PriceItem("АСОМИ", "А108.2905.580-Р", "Корпус стойки передней подвески авт. " +
                "ВАЗ 2108 правый в сборе под картридж", 54563, 1));
        list.add(new PriceItem("АСОМИ", "А108.2905.581-Р", "Корпус стойки передней подвески авт. " +
                "ВАЗ 2108 левый в сборе под картридж", 54563, 1));
        list.add(new PriceItem("АСОМИ", "А110.2905.580-Р", "Корпус стойки", 51986, 3));
        list.add(new PriceItem("АСОМИ", "А110.2905.581-Р", "Корпус стойки", 51986, 3));
    }

    @org.junit.jupiter.api.Test
    void parseToList() {
        myCSVParser.parseToList(DIR);
        assertEquals(list, myCSVParser.parseToList(DIR));
    }

    @org.junit.jupiter.api.Test
    void getPriceAsList() {
        assertEquals(list, myCSVParser.getPriceAsList());
    }
}