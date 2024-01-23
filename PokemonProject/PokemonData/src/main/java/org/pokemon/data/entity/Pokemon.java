package org.pokemon.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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

	public Integer getOrder() {
		return orderNumber;
	}





}
