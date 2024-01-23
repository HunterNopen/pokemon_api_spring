package org.pokemon.data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonDto{

	private Integer id;
	private String name;
	@JsonProperty("base_experience")
	private Integer baseExperience;
	private Integer height;
	@JsonProperty("is_default")
	private Boolean isDefault;
	private Integer order;
	private Integer weight;
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;
	private PokemonSpritesDto sprites;
	private List<PokemonAbilitiesDto> abilities;
	@JsonProperty("held_items")
	private List<PokemonHeldItemDto> heldItems;
	private List<PokemonStatsDto> stats;
	private List<PokemonTypesDto> types;

	public Integer getOrderNumber() {
		return order;
	}

	public void setOrderNumber(Integer order) {
		this.order = order;
	}

}
