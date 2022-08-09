package ru.netology.Book.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmartphoneTest {
    Repository repo = new Repository();
    ManagerProduct manager = new ManagerProduct(repo);
    Smartphone smartphone1 = new Smartphone(1, "Smart1", 100, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(2, "Smart2", 300, "Manufacturer2");
    Smartphone smartphone3 = new Smartphone(3, "Smart3", 100, "Manufacturer3");
    Smartphone smartphone4 = new Smartphone(4, "Smart4", 500, "Manufacturer4");

    @Test
    public void SmartphoneTest() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("Smart");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void smartphoneTestSetManufacturer() {
        this.smartphone2.setManufacturer("Manufacturer222");
        String actual = this.smartphone2.getManufacturer();
        String expected = "Manufacturer222";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void smartphoneTestSetName() {
        this.smartphone2.setName("Name222");
        String actual = this.smartphone2.getName();
        String expected = "Name222";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void smartphoneTestSetPrice() {
        this.smartphone1.setPrice(1500);
        int actual = this.smartphone1.getPrice();
        int expected = 1500;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void smartphoneTestSetId() {
        this.smartphone2.setId(2);
        int actual = this.smartphone2.getId();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }


}