package br.edu.unisep.albumcup.usecase;

import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.dto.StickerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllStickersUseCaseImpl implements FindAllStickersUseCase{

    private final StickerRepository repository;

    @Override
    public List<StickerDto> execute() {
        var result = repository.findAll();
        return result.stream().map(sticker -> {
            var dto = new StickerDto();
            dto.setId(sticker.getId());
            dto.setPlayer(sticker.getPlayer());
            dto.setCountry(sticker.getCountry());
            dto.setHeight(sticker.getHeight());
            dto.setWeight(sticker.getWeight());
            dto.setBirthday(sticker.getBirthday());
            dto.setLegendary(sticker.isLegendary());

            return dto;
        }).toList();
    }
}
