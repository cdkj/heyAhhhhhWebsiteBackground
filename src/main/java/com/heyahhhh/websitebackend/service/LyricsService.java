package com.heyahhhh.websitebackend.service;

import com.heyahhhh.websitebackend.entity.LyricDO;

public interface LyricsService {

    public boolean initializeDatabase();

    public boolean addSongFromFile(String song, String singer);

    public boolean addSongFromDict(String singer);

    public LyricDO getRandomLyric();
}
