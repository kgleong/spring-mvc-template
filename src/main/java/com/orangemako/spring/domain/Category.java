package com.orangemako.spring.domain;

/**
 * Item categories.
 *
 * @author Kevin Leong
 */
public enum Category {
    SPORTING_GOODS("sporting goods"),
    COMPUTER_EQUIPMENT("computer equipment");

    private String name;

    Category(String name) {
        this.name = name;
    }

}
