package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #1 ItemRepository.
public interface ItemRepository extends JpaRepository<Item, Long> {
}
