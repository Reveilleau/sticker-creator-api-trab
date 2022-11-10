package br.edu.unisep.albumcup.controller;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.dto.CreateStickerDto;
import br.edu.unisep.albumcup.usecase.CreateStickerUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sticker")
public class StickerController {

    private final StickerRepository repository;
    private final CreateStickerUseCase createStickerUseCase;

    public StickerController(StickerRepository repo, CreateStickerUseCase createStickerUseCase) {
        this.repository = repo;
        this.createStickerUseCase = createStickerUseCase;
    }

    @PostMapping
    public void save(@RequestBody CreateStickerDto stickerData) {
        createStickerUseCase.execute(stickerData);
    }

    @GetMapping
    public List<Sticker> findAll() {
        return repository.findAll();
    }
}
