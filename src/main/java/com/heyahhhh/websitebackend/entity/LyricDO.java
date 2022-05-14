package com.heyahhhh.websitebackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "lyrics")
public class LyricDO {

    public LyricDO(String lyric, Long songID) {
        this.songID = songID;
        this.lyric = lyric;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length= 255)
    private String lyric;

    @Column(nullable = false)
    private Long songID;

}
