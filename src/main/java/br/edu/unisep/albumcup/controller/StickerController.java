package br.edu.unisep.albumcup.controller;

import br.edu.unisep.albumcup.dto.CreateStickerDto;
import br.edu.unisep.albumcup.dto.StickerDto;
import br.edu.unisep.albumcup.usecase.CreateStickerUseCase;
import br.edu.unisep.albumcup.usecase.FindAllStickersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sticker")
@RequiredArgsConstructor
public class StickerController {

    private final CreateStickerUseCase createStickerUseCase;
    private final FindAllStickersUseCase findAllStickersUseCase;

    @PostMapping
    public void save(@RequestBody CreateStickerDto stickerData) {
        createStickerUseCase.execute(stickerData);
    }

    @GetMapping
    public List<StickerDto> findAll() {
        return findAllStickersUseCase.execute();
    }
}
