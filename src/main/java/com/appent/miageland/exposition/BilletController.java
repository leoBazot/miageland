package com.appent.miageland.exposition;

import com.appent.miageland.entities.Billet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/billets")
public class BilletController {

    @GetMapping("{id}")
    public Billet getBillet(Long id) {
        return null;
    }
}
