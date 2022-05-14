package com.heyahhhh.websitebackend.service.impl;

import com.heyahhhh.websitebackend.entity.LyricDO;
import com.heyahhhh.websitebackend.entity.SongDO;
import com.heyahhhh.websitebackend.repository.LyricsRepository;
import com.heyahhhh.websitebackend.repository.SongsRepository;
import com.heyahhhh.websitebackend.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class LyricsServiceImpl implements LyricsService {

    @Autowired
    private LyricsRepository lyricsRepository;

    @Autowired
    private SongsRepository songsRepository;

    @Value("${data.lyrics}")
    private String dataDir;

    @Override
    public boolean initializeDatabase() {
        songsRepository.deleteAll();
        lyricsRepository.deleteAll();
        return true;
    }

    @Override
    public boolean addSongFromFile(String song, String singer) {
        Optional<SongDO> songDOOptional = songsRepository.findByNameAndSinger(song, singer);
        if ( songDOOptional.isPresent() ) {
            return false;
        }
        else {
            try {
                BufferedReader br;
                if (dataDir.equals("jar")){
                    br = new BufferedReader(new InputStreamReader(new ClassPathResource("lyrics/" + singer + "/" + song + ".txt").getInputStream()));
                }
                else {
                    br = new BufferedReader(new FileReader(dataDir + singer + "/" + song + ".txt"));
                }
                songsRepository.save(new SongDO(song, singer));
                Long songID  = songsRepository.findIDByNameAndSinger(song, singer);
                Set<String> lyricTexts = new TreeSet<>(); // remove duplicated text
                String line;
                while ((line = br.readLine()) != null) {
                    lyricTexts.add(line);
                }
                ArrayList<LyricDO> lyricDOS = new ArrayList<>();
                for(String lyric : lyricTexts) {
                    lyricDOS.add(new LyricDO(lyric, songID));
                }
                lyricsRepository.saveAll(lyricDOS);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean addSongFromDict(String singer) {
        return false;
    }

    @Override
    public LyricDO getRandomLyric() {
        return null;
    }
}
