package com.nhnent.edu.spring_jpa.service;

import com.nhnent.edu.spring_jpa.assembler.ItemAssembler;
import com.nhnent.edu.spring_jpa.dto.ItemDto;
import com.nhnent.edu.spring_jpa.entity.Item;
import com.nhnent.edu.spring_jpa.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// TODO : #9 item service
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;


    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public List<ItemDto> getItems(Pageable pageable) {
        Page<Item> itemPage = itemRepository.findAll(pageable);

        return itemPage.getContent()
                       .stream()
                       .map(item -> new ItemAssembler().toDto(item))
                       .collect(Collectors.toList());
    }

}
