package com.orangemako.spring.domain;

/**
 * Item class.
 *
 * @author Kevin Leong
 */
public class Item {

    private int id;
    private String name;
    private Category category;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
