package com.vinogorova.mailparser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagePriceItemsLoadTest {
    private List<PriceItem> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(new PriceItem("АСОМИ", "А108.2905.580-Р", "Корпус стойки передней подвески авт. " +
                "ВАЗ 2108 правый в сборе под картридж", 54563, 1));
        list.add(new PriceItem("АСОМИ", "А108.2905.581-Р", "Корпус стойки передней подвески авт. " +
                "ВАЗ 2108 левый в сборе под картридж", 54563, 1));
        list.add(new PriceItem("АСОМИ", "А110.2905.580-Р", "Корпус стойки", 51986, 3));
        list.add(new PriceItem("АСОМИ", "А110.2905.581-Р", "Корпус стойки", 51986, 3));
    }

    @Test
    void addPriceItems() {
        ManagePriceItemsLoad.addPriceItems(list);
    }
}