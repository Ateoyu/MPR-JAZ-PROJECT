package pjatk.edu.pl.backend.service.mapper;

import pjatk.edu.pl.data.dto.TitleDto;
import pjatk.edu.pl.data.model.Title;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper implements EntityMapper<Title, TitleDto> {

    @Override
    public Title toEntity(TitleDto dto) {
        return new Title(dto.english(), dto.romaji(), dto.local());
    }

    @Override
    public TitleDto toDto(Title entity) {
        return new TitleDto(entity.getEnglish(), entity.getRomaji(), entity.getLocal());
    }
}