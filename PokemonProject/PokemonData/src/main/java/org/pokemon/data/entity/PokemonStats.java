package org.pokemon.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pokemon_stats")
public class PokemonStats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer effort;
	private Integer baseStat;
	@ManyToOne
	@JoinColumn(name = "stat_id")
	private Stat stat;
	@ManyToOne
	@JoinColumn(name = "pokemon_id")
	private Pokemon pokemon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEffort() {
		return effort;
	}

	public void setEffort(Integer effort) {
		this.effort = effort;
	}

	public Integer getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(Integer baseStat) {
		this.baseStat = baseStat;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
}
