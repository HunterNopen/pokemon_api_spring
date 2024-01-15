package org.pokemon.mappers;

import org.pokemon.data.dto.ItemDto;
import org.pokemon.data.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements IMap<ItemDto, Item> {
    @Override
    public Item map(ItemDto itemDto) {
        return map(itemDto, new Item());
    }

    @Override
    public Item map(ItemDto itemDto, Item item) {
        item.setName(itemDto.getName());
        item.setUrl(itemDto.getUrl());
        return item;
    }
}
