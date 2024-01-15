package org.pokemon.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pokemon{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer baseExperience;
	private Integer height;
	private Boolean isDefault;
	private Integer orderNumber;
	private Integer weight;
	private String locationAreaEncounters;
	@OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PokemonAbilities> abilities=new ArrayList<>();
	@OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PokemonHeldItems> heldItems=new ArrayList<>();
	@OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PokemonStats> stats=new ArrayList<>();
	@OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PokemonTypes> types=new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "sprites_id")
	private PokemonSprites sprites;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Boolean getDefault() {
		return isDefault;
	}

	public void setDefault(Boolean aDefault) {
		isDefault = aDefault;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getLocationAreaEncounters() {
		return locationAreaEncounters;
	}

	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}

	public List<PokemonAbilities> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<PokemonAbilities> abilities) {
		this.abilities = abilities;
	}

	public List<PokemonHeldItems> getHeldItems() {
		return heldItems;
	}

	public void setHeldItems(List<PokemonHeldItems> heldItems) {
		this.heldItems = heldItems;
	}

	public List<PokemonStats> getStats() {
		return stats;
	}

	public void setStats(List<PokemonStats> stats) {
		this.stats = stats;
	}

	public List<PokemonTypes> getTypes() {
		return types;
	}

	public void setTypes(List<PokemonTypes> types) {
		this.types = types;
	}

	public PokemonSprites getSprites() {
		return sprites;
	}

	public void setSprites(PokemonSprites sprites) {
		this.sprites = sprites;
	}
}
