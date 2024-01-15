package org.pokemon.client.settings;

import org.springframework.web.util.UriComponentsBuilder;

public interface IClientSettings {

    String getBaseUrl();
    String getApiVersion();

    default UriComponentsBuilder getUrlBuilder(){
        return UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(getBaseUrl())
                .pathSegment("api",getApiVersion()+"");
    }
}
