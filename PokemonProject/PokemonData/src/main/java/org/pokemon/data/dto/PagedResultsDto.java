package org.pokemon.data.dto;

import java.util.List;

public class PagedResultsDto {
    private List<PokemonSummarizingDto> results;

    public List<PokemonSummarizingDto> getResults() {
        return results;
    }

    public void setResults(List<PokemonSummarizingDto> results) {
        this.results = results;
    }
}
