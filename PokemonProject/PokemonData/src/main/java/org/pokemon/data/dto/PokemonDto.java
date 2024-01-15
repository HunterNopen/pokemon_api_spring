package org.pokemon.data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseExperience() {
		return baseExperience;
	}
	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public List<PokemonAbilitiesDto> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<PokemonAbilitiesDto> abilities) {
		this.abilities = abilities;
	}
	public List<PokemonHeldItemDto> getHeldItems() {
		return heldItems;
	}
	public void setHeldItems(List<PokemonHeldItemDto> heldItems) {
		this.heldItems = heldItems;
	}
	public String getLocationAreaEncounters() {
		return locationAreaEncounters;
	}
	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}
	public PokemonSpritesDto getSprites() {
		return sprites;
	}
	public void setSprites(PokemonSpritesDto sprites) {
		this.sprites = sprites;
	}
	public List<PokemonStatsDto> getStats() {
		return stats;
	}
	public void setStats(List<PokemonStatsDto> stats) {
		this.stats = stats;
	}
	public List<PokemonTypesDto> getTypes() {
		return types;
	}
	public void setTypes(List<PokemonTypesDto> types) {
		this.types = types;
	}
}
