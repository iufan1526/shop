package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemName(String itemName);
    List<Item> findByItemNameOrItemText(String itemName , String itemText);
    
    @Query("select i from Item i where i.itemText like %:itemText% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemText")String itemText);
}
