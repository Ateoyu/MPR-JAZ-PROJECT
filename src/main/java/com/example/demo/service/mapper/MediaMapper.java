package com.example.demo.service.mapper;

import com.example.demo.dto.MediaDto;
import com.example.demo.model.Character;
import com.example.demo.model.Genre;
import com.example.demo.model.Media;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MediaMapper implements EntityMapper<Media, MediaDto> {
    private final TitleMapper titleMapper;
    private final DateMapper dateMapper;
    private final CharacterMapper characterMapper;
    private final GenreMapper genreMapper;


    @Override
    public Media toEntity(MediaDto dto) {
        if (dto == null) {
            return null;
        }

        Media media = Media.builder()
                .anilistId(dto.id())
                .title(titleMapper.toEntity(dto.title()))
                .coverImage(dto.image().medium())
                .episodes(dto.episodes())
                .averageScore(dto.averageScore())
                .startDate(dateMapper.toEntity(dto.startDate()))
                .endDate(dateMapper.toEntity(dto.endDate()))
                .build();

        if (dto.genres() != null) {
            Set<Genre> genreSet = dto.genres().stream()
                    .map(genreMapper::toEntity)
                    .collect(Collectors.toSet());

            media.setGenres(genreSet);
        }

        if (dto.characters() != null) {
            Set<Character> characterSet = dto.characters().list().stream()
                    .map(characterMapper::toEntity)
                    .collect(Collectors.toSet());

            media.setCharacters(characterSet);
        }

        return media;
    }

    @Override
    public MediaDto toDto(Media entity) {
        return null;
    }
}
