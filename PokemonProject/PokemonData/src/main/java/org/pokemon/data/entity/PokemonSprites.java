package org.pokemon.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class PokemonSprites {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String frontDefault;
	private String frontShiny;
	private String frontFemale;
	private String frontShinyFemale;
	private String backDefault;
	private String backShiny;
	private String backFemale;
	private String backShinyFemale;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Pokemon pokemon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrontDefault() {
		return frontDefault;
	}

	public void setFrontDefault(String frontDefault) {
		this.frontDefault = frontDefault;
	}

	public String getFrontShiny() {
		return frontShiny;
	}

	public void setFrontShiny(String frontShiny) {
		this.frontShiny = frontShiny;
	}

	public String getFrontFemale() {
		return frontFemale;
	}

	public void setFrontFemale(String frontFemale) {
		this.frontFemale = frontFemale;
	}

	public String getFrontShinyFemale() {
		return frontShinyFemale;
	}

	public void setFrontShinyFemale(String frontShinyFemale) {
		this.frontShinyFemale = frontShinyFemale;
	}

	public String getBackDefault() {
		return backDefault;
	}

	public void setBackDefault(String backDefault) {
		this.backDefault = backDefault;
	}

	public String getBackShiny() {
		return backShiny;
	}

	public void setBackShiny(String backShiny) {
		this.backShiny = backShiny;
	}

	public String getBackFemale() {
		return backFemale;
	}

	public void setBackFemale(String backFemale) {
		this.backFemale = backFemale;
	}

	public String getBackShinyFemale() {
		return backShinyFemale;
	}

	public void setBackShinyFemale(String backShinyFemale) {
		this.backShinyFemale = backShinyFemale;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
}
