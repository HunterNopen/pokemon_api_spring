package org.pokemon.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="pokemon_abilities")
public class PokemonAbilities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private Boolean isHidden;
	private Integer slot;

	@ManyToOne
	@JoinColumn(name = "ability_id")
	private Ability ability;

	@ManyToOne
	@JoinColumn(name = "pokemon_id")
	private Pokemon pokemon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getHidden() {
		return isHidden;
	}

	public void setHidden(Boolean hidden) {
		isHidden = hidden;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
}
