package br.edu.unisep.albumcup.usecase;

import br.edu.unisep.albumcup.dto.StickerDto;

import java.util.List;

public interface FindAllStickersUseCase {
    List<StickerDto> execute();
}
