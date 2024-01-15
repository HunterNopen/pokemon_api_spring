package org.pokemon.client.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PokemonClientSettings implements IClientSettings{
    @Value("${pokemon.api.host}")
    private String baseUrl;
    @Value("${pokemon.version.api}")
    private String apiVersion;

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public String getApiVersion() {
        return apiVersion;
    }
}
