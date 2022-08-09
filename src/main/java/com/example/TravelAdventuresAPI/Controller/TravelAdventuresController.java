package com.codecademy.plants.controllers;

import com.codecademy.plants.entities.Adventure;
import com.codecademy.plants.repositories.AdventureRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@RestController ("/traveladventures")
public class TravelAdventuresController {

    private final AdventureRepository adventureRepository;

    public TravelAdventuresController(AdventureRepository adventureRepo) {
        this.adventureRepository = adventureRepo;
    }

    // Add controller methods below:
    @GetMapping()
    public Iterable<Adventure> getAllAdventures(){
        return this.adventureRepository.findAll();
    }

    @GetMapping("/bycountry/{country}")
    public List<Adventure> getByCountry(@PathVariable("country") String
                                                country) {
        return this.adventureRepository.findByCountry(country);
    }

}
