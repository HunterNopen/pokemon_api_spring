package org.pokemon.data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PokemonStatsDto {
	private Integer effort;
	@JsonProperty("base_stat")
	private Integer baseStat;
	private StatDto stat;
	
	public StatDto getStat() {
		return stat;
	}
	public void setStat(StatDto stat) {
		this.stat = stat;
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
	
}
