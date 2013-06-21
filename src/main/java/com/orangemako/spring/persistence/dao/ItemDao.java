package com.orangemako.spring.persistence.dao;

import com.orangemako.spring.domain.Item;

import java.util.List;

/**
 * Item Data Access Object.
 *
 * @author Kevin Leong
 */
public interface ItemDao {
    public List<Item> getAllItems();

    public List<Item> getById();

    public void createItem();
}
