package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.annotation.Question;
import com.nhnent.edu.spring_jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
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

    // TODO : #1 실습 - 다음 메서드의 이름을 아래 쿼리 결과가 나오도록 이름 규칙에 맞춰 수정하세요.
    //        select * from Items where price in (...)
    // TODO : #1 practice - modify the following method name to query like
    //        select * from Items where price in (...)
    @Question
    List<Item> changeThisMethodName(Collection<Long> prices);

}
