package com.nhnent.edu.spring_jpa.service;

import com.nhnent.edu.spring_jpa.dto.ItemDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    List<ItemDto> getItems(Pageable pageable);

}
