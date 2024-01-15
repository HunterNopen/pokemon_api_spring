package org.pokemon.data.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PokemonHeldItemDto {

	private ItemDto item;
	
	public ItemDto getItem() {
		return item;
	}
	public void setItem(ItemDto item) {
		this.item = item;
	}
	
}
