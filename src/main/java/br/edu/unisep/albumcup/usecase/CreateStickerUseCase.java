package br.edu.unisep.albumcup.usecase;

import br.edu.unisep.albumcup.dto.CreateStickerDto;

public interface CreateStickerUseCase {
    void execute(CreateStickerDto stickerData);
}
