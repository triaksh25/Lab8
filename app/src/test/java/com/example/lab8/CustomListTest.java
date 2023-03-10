package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        City city = mockCity();
        list.addCity(city);
        assertTrue(list.hasCity(city));
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertFalse(list.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertThrows(IllegalArgumentException.class, () ->{
            list.deleteCity(city);
        });

        City city1 = mockCity();
        list.addCity(city1);
        list.deleteCity(city1);
        assertFalse(list.hasCity(city1));
    }

    @Test
    void testCount() {
        list = MockCityList();
        list.addCity(mockCity());
        assertEquals(1, list.countCities());
    }
}
