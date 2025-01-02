package com.example.demo.repository;

import com.example.demo.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<Media, Integer> {
    Optional<Media> findByAnilistId(Integer anilistId);
}
