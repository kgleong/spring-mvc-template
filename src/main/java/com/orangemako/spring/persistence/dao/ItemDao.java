package com.orangemako.spring.persistence.dao;

import com.orangemako.spring.domain.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Item Data Access Object.
 *
 * @author Kevin Leong
 */
@Repository
public interface ItemDao {

    @Select("SELECT * FROM items")
    public List<Item> getAllItems();

    @Select("SELECT * FROM items WHERE id = #{itemId}")
    public Item getById(@Param("itemId") String itemId);

    @Insert("INSERT INTO items (name, category, price) VALUES (#{name}, #{category}, #{price})")
    public int insertItem(Item item);
}
