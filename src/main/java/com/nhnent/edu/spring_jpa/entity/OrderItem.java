package com.nhnent.edu.spring_jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/*
create table if not exists `OrderItems` (
  `order_id` bigint not null,
  `line_number` integer not null,
  `item_id` bigint not null,
  `quantity` integer not null,

  primary key(`order_id`, `line_number`)
);

 */
// TODO : #1 define a entity graph using @NamedEntityGraph.
@NamedEntityGraphs({
        @NamedEntityGraph(name = "orderItemWithItem", attributeNodes = {
                @NamedAttributeNode("item")
        }),
        @NamedEntityGraph(name = "orderItemWithItemAndOrder", attributeNodes = {
                @NamedAttributeNode("item"),
                @NamedAttributeNode("order")
        })
})
@Entity
@Table(name = "OrderItems")
public class OrderItem {
    @EmbeddedId
    private Pk pk;

    private Integer quantity;


    @JoinColumn(name = "item_id")
    @ManyToOne(fetch = FetchType.LAZY)          // LAZY!!!
    private Item item;

    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;


    public Pk getPk() {
        return pk;
    }

    public void setPk(Pk pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "line_number")
        private Integer lineNumber;


        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pk pk = (Pk) o;
            return orderId.equals(pk.orderId) &&
                   lineNumber.equals(pk.lineNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId, lineNumber);
        }

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Integer getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(Integer lineNumber) {
            this.lineNumber = lineNumber;
        }

    }

}
