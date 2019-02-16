package com.nhnent.edu.spring_jpa.repository;

import com.nhnent.edu.spring_jpa.entity.Item;
import com.nhnent.edu.spring_jpa.entity.QItem;
import com.nhnent.edu.spring_jpa.entity.QOrder;
import com.nhnent.edu.spring_jpa.entity.QOrderItem;

import java.util.List;

/*
 * custom repository를 구현하세요.
 */
// TODO : #3 실습 - querydsl를 이용해 custom repository를 구현하려면 상속받아야 하는 추상 클래스를 작성하세요.
// TODO : #3 practice - complete the custom repository implementation class below. 
public class OrderRepositoryImpl extends Object/*???*/
        implements OrderRepositoryCustom {
    public OrderRepositoryImpl() {
        // TODO : #4 실습 - 적절한 생성자 호출 구문을 쓰세요.
    	// TODO : #4 practice - write a proper constructor call.
        // ???
    }

    @Override
    public List<Item> getItemsHavingOrderItemQuantityGreaterThan(int quantity) {
        return null;
        // TODO : #5 3번 항목까지 모두 완료하였으면 위의 return null 구문을 삭제하고 아래 주석을 해제하세요.
        // TODO : #5 if you've finished the previous todos,
        //        remove the above `return null` statement and uncomment the following lines.
        /*
        QOrder order = QOrder.order;
        QOrderItem orderItem = QOrderItem.orderItem;
        QItem item = QItem.item;

        return from(order)
                .innerJoin(order.orderItems, orderItem)
                .innerJoin(orderItem.item, item)
                .where(orderItem.quantity.gt(quantity))
                .select(item)
                .distinct()
                .fetch();
        */
    }

}
