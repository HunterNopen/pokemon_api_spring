package org.pokemon.data.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PokemonTypesDto {

	private Integer slot;
	private TypeDto type;
	
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	public TypeDto getType() {
		return type;
	}
	public void setType(TypeDto type) {
		this.type = type;
	}
	
}
