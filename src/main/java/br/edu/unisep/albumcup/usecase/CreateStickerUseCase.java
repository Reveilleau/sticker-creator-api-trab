package br.edu.unisep.albumcup.usecase;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.dto.CreateStickerDto;
import org.springframework.stereotype.Component;

@Component
public class CreateStickerUseCase {

    private final StickerRepository repository;

    public CreateStickerUseCase(StickerRepository repository) {
        this.repository = repository;
    }

    public void execute(CreateStickerDto stickerData) {
        Sticker sticker = new Sticker();
        sticker.setPlayer(stickerData.getPlayer());
        sticker.setCountry(stickerData.getCountry());
        sticker.setWeight(stickerData.getWeight());
        sticker.setHeight(stickerData.getHeight());
        sticker.setLegendary(stickerData.isLegendary());

        repository.save(sticker);
    }
}
