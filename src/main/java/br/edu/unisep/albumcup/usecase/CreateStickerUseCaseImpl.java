package br.edu.unisep.albumcup.usecase;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.dto.CreateStickerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStickerUseCaseImpl implements CreateStickerUseCase{

    private final StickerRepository repository;

    public void execute(CreateStickerDto stickerData) {
        var sticker = new Sticker();
        sticker.setPlayer(stickerData.getPlayer());
        sticker.setCountry(stickerData.getCountry());
        sticker.setWeight(stickerData.getWeight());
        sticker.setHeight(stickerData.getHeight());
        sticker.setLegendary(stickerData.isLegendary());
        sticker.setBirthday(stickerData.getBirthday());

        repository.save(sticker);
    }
}
