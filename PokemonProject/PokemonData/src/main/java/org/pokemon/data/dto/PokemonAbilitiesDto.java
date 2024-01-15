package org.pokemon.data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PokemonAbilitiesDto {
	@JsonProperty("is_hidden")
	private Boolean isHidden;
	private Integer slot;
	private AbilityDto ability;
	
	public Boolean getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	public AbilityDto getAbility() {
		return ability;
	}

	public void setAbility(AbilityDto ability) {
		this.ability = ability;
	}
}
