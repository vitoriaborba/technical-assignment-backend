package com.example.brewery_backend;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.ValidationException;

import java.util.List;

@RestController
@RequestMapping("/api/breweries")
@Validated

public class BreweryController {

    private final BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping
    public List<Brewery> getBreweries(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "perPage", defaultValue = "10") int perPage) {
        return breweryService.getBreweries(page, perPage);
    }

    @GetMapping("/search")
    public List<Brewery> searchBreweries(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "perPage", defaultValue = "10") int perPage) {

        // Validate parameters
        if (name != null && !name.matches("^[a-zA-Z0-9 ]*$")) {
            throw new ValidationException("Name should only contain letters, numbers, and spaces");
        }
        if (city != null && !city.matches("^[a-zA-Z ]*$")) {
            throw new ValidationException("City should only contain letters and spaces");
        }
        if (state != null && !state.matches("^[a-zA-Z ]*$")) {
            throw new ValidationException("State should only contain letters and spaces");
        }
        if (type != null && !type.matches("^[a-zA-Z ]*$")) {
            throw new ValidationException("Brewery type should only contain letters and spaces");
        }

        BrewerySearchRequest request = new BrewerySearchRequest();
        request.setName(name);
        request.setCity(city);
        request.setState(state);
        request.setBreweryType(type);

        return breweryService.searchBreweries(request, page, perPage);
    }


    @GetMapping("/{id}")
    public Brewery getBreweryById(@PathVariable("id") String id) {
        return breweryService.getBreweryById(id);
    }
}