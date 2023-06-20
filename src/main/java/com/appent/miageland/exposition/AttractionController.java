package com.appent.miageland.exposition;

import com.appent.miageland.entities.Attraction;
import com.appent.miageland.services.AttractionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/attractions")
@AllArgsConstructor
public class AttractionController {

    private final AttractionService attractionService;

    @GetMapping
    public Collection<Attraction> getListAttractions() {
        return this.attractionService.getAllAttractions();
    }
}
