package com.orangemako.spring.service;

import com.orangemako.spring.domain.Item;
import com.orangemako.spring.persistence.dao.ItemDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Item service class.
 *
 * @author Kevin Leong
 */
@Service
public class ItemService {
    private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);

    @Resource
    ItemDao itemDao;

    /**
     * Returns all items.
     * @return
     */
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    /**
     * Retrieves an item by it's ID
     * @param itemId
     * @return
     */
    public Item getById(String itemId) {
        return itemDao.getById(itemId);
    }

    /**
     * Inserts an item.
     *
     * @param item
     * @return Number of records added.  Should be 1 on a successful insert.
     */
    public int insertItem(Item item) {
        return itemDao.insertItem(item);
    }
}
