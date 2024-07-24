package com.example.brewery_backend;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BreweryService {

    @Value("${openbrewerydb.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public BreweryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Brewery> getBreweries(int page, int perPage) {
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("page", page)
                .queryParam("per_page", perPage)
                .build()
                .toUri();

        Brewery[] breweries = restTemplate.getForObject(uri, Brewery[].class);
        if (breweries == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(breweries);
    }

    public List<Brewery> searchBreweries(@Valid BrewerySearchRequest request, int page, int perPage) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("page", page)
                .queryParam("per_page", perPage);

        // query parameters based on the request object
        if (request.getName() != null && !request.getName().isEmpty()) {
            uriBuilder.queryParam("by_name", request.getName());
        }
        if (request.getCity() != null && !request.getCity().isEmpty()) {
            uriBuilder.queryParam("by_city", request.getCity());
        }
        if (request.getState() != null && !request.getState().isEmpty()) {
            uriBuilder.queryParam("by_state", request.getState());
        }
        if (request.getBreweryType() != null && !request.getBreweryType().isEmpty()) {
            uriBuilder.queryParam("by_type", request.getBreweryType());
        }

        URI uri = uriBuilder.build().toUri();

        Brewery[] breweries = restTemplate.getForObject(uri, Brewery[].class);
        if (breweries == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(breweries);
    }

    public Brewery getBreweryById(String id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(apiUrl + "/" + id)
                .build()
                .toUri();
        return restTemplate.getForObject(uri, Brewery.class);
    }
}