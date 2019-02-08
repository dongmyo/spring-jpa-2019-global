package com.nhnent.edu.spring_jpa.assembler;

import com.nhnent.edu.spring_jpa.dto.ItemDto;
import com.nhnent.edu.spring_jpa.entity.Item;

public class ItemAssembler {
    public ItemDto toDto(Item item) {
        return new ItemDto(item.getItemId(), item.getItemName(), item.getPrice());
    }

}
