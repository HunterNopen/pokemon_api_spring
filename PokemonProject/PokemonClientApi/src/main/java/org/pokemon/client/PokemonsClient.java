package org.pokemon.client;

import org.pokemon.client.settings.IClientSettings;
import org.pokemon.client.settings.IPokemonClient;
import org.pokemon.data.dto.PagedResultsDto;
import org.pokemon.data.dto.PokemonDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonsClient implements IPokemonClient {
    RestTemplate restClient;
    String baseUrl;
    String version;
    private final IClientSettings _settings;

    public PokemonsClient(IClientSettings settings) {
        restClient = new RestTemplate();
        this.baseUrl=settings.getBaseUrl();
        this.version= settings.getApiVersion();
        _settings=settings;
    }


    @Override
    public PokemonDto getPokemonByName(String name) {
        var url = _settings.getUrlBuilder()
                .pathSegment("pokemon", name)
                .build()
                .toUriString();
        var result=restClient.getForEntity(url, PokemonDto.class).getBody();
        return result;
    }

    @Override
    public PagedResultsDto getPokemons(int limit) {
        var url = _settings.getUrlBuilder()
                .pathSegment("pokemon")
                .queryParam("limit", limit)
                .queryParam("offset", 0)
                .build()
                .toUriString();
        var result=restClient.getForEntity(url, PagedResultsDto.class).getBody();
        return result;
    }
}
