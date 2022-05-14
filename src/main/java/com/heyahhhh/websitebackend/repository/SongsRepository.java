package com.heyahhhh.websitebackend.repository;

import com.heyahhhh.websitebackend.entity.SongDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongsRepository extends JpaRepository<SongDO, Long> {
    Optional<SongDO> findByNameAndSinger(String name, String singer);

    @Query(value = "select id from songs s where s.name = ?1 and s.singer = ?2", nativeQuery = true)
    Long findIDByNameAndSinger(String name, String singer);
}
