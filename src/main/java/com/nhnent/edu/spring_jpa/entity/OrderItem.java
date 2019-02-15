package com.nhnent.edu.spring_jpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

// TODO : #1 `OrderItem` Entity class.
/*
create table if not exists `OrderItems` (
  `order_id` bigint not null,
  `line_number` integer not null,
  `item_id` bigint not null,
  `quantity` integer not null,

  primary key(`order_id`, `line_number`)
);

 */
@Entity
@Table(name = "OrderItems")
public class OrderItem {
    @EmbeddedId
    private Pk pk;

    @Column(name = "item_id")
    private Long itemId;

    private Integer quantity;


    public Pk getPk() {
        return pk;
    }

    public void setPk(Pk pk) {
        this.pk = pk;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
