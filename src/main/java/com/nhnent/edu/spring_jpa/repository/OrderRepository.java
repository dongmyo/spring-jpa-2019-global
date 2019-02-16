package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO : #6 실습 - 기본 repository가 custom repository를 상속하도록 수정하세요.
// TODO : #6 practice - modify the following repository to extend custom repository one.
public interface OrderRepository extends /*???*/ JpaRepository<Order, Long> {
}
