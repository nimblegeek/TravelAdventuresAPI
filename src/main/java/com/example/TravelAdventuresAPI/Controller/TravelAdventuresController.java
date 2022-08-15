package com.example.TravelAdventuresAPI.Controller;

import com.codecademy.plants.entities.Adventure;
import com.example.TravelAdventuresAPI.repository.AdventureRepository;
import org.springframework.web.bind.annotation.*;


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
    public List<Adventure> getByCountry(@PathVariable("country") String country) {
        List<Adventure> byCountry = this.adventureRepository.findByCountry(country);
        return byCountry;
    }
    @GetMapping("/bystate")
    public List<Adventure> getByState(@RequestParam(name="state") String
                                              state) {
        return this.adventureRepository.findByState(state);
    }


}
