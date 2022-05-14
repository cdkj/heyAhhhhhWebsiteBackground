package com.heyahhhh.websitebackend.repository;

import com.heyahhhh.websitebackend.entity.LyricDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LyricsRepository extends JpaRepository<LyricDO, Long> {

    @Query(value = "select * from lyrics l where l.id = ?1", nativeQuery = true)
    Optional<LyricDO> findById(Long id);

    @Query(value = "select count(*) from lyrics", nativeQuery = true)
    Long findTotalCounts();

}
