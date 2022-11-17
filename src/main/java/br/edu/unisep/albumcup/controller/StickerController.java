package br.edu.unisep.albumcup.controller;

import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;
import br.edu.unisep.albumcup.domain.dto.StickerDto;
import br.edu.unisep.albumcup.domain.usecase.CreateStickerUseCase;
import br.edu.unisep.albumcup.domain.usecase.DeleteStickerUseCase;
import br.edu.unisep.albumcup.domain.usecase.FindAllStickersUseCase;
import br.edu.unisep.albumcup.domain.usecase.FindStickerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sticker")
@RequiredArgsConstructor
public class StickerController {

    private final FindStickerByIdUseCase findStickerByIdUseCase;
    private final CreateStickerUseCase createStickerUseCase;
    private final FindAllStickersUseCase findAllStickersUseCase;
    private final DeleteStickerUseCase deleteStickerUseCase;

    @PostMapping
    public ResponseEntity save(@RequestBody CreateStickerDto stickerData) {
        createStickerUseCase.execute(stickerData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<StickerDto>> findAll() {
        var result = findAllStickersUseCase.execute();

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{sticker_id}")
    public ResponseEntity<StickerDto> findById(@PathVariable(value="sticker_id" ) Integer id) {
        var result = findStickerByIdUseCase.execute(id);

        if (result == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{sticker_id}")
    public ResponseEntity deleteById(@PathVariable(value="sticker_id" ) Integer id) {
        deleteStickerUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
