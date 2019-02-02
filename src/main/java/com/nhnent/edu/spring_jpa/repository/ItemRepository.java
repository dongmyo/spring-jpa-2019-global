package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.annotation.Question;
import com.nhnent.edu.spring_jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Collection;
import java.util.List;

// TODO : #1 ItemRepository가 QuerydslPredicateExecutor를 상속받도록 수정.
public interface ItemRepository extends QuerydslPredicateExecutor<Item>, JpaRepository<Item, Long> {
    // select * from Items where item_name like '%{itemName}%'
    Item findByItemNameLike(String itemName);

    // select item_id from Items
    // where item_name = '{itemName}'
    // and price = {price} limit 1
    boolean existsByItemNameAndPrice(String itemName, Long price);

    // select count(*) from Items where item_name like '%{itemName}%'
    int countByItemNameLike(String itemName);

    // delete from Items where price between {price1} and {price2}
    void deleteByPriceBetween(long price1, long price2);

    @Question
    List<Item> findByPriceIn(Collection<Long> prices);

}
