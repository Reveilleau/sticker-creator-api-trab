package br.edu.unisep.albumcup.domain.usecase;

import br.edu.unisep.albumcup.domain.dto.StickerDto;

public interface FindStickerByIdUseCase {

    StickerDto execute(Integer id);
}

