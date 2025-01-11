package pjatk.edu.pl.backend.service.mapper;

import pjatk.edu.pl.data.dto.NameDto;
import pjatk.edu.pl.data.model.Name;
import org.springframework.stereotype.Component;

@Component
public class NameMapper implements EntityMapper<Name, NameDto> {

    @Override
    public Name toEntity(NameDto dto) {
        return new Name(dto.full(), dto.local());
    }

    @Override
    public NameDto toDto(Name entity) {
        return new NameDto(entity.getFull(), entity.getLocal());
    }
}