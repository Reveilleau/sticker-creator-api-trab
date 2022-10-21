package br.edu.unisep.albumcup.controller;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sticker")
public class StickerController {

    private StickerRepository repository;

    public StickerController(StickerRepository repo) {
        this.repository = repo;
    }

    @PostMapping
    public void save(@RequestBody Sticker sticker) {
        repository.save(sticker);
    }
}
