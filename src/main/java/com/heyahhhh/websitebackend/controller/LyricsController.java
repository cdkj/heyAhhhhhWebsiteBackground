package com.heyahhhh.websitebackend.controller;

import com.heyahhhh.websitebackend.service.LyricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lyrics/")
public class LyricsController {

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value = "/initialize", method = RequestMethod.GET)
    public boolean initializeDatabase() {
        return lyricsService.initializeDatabase();
    }

    @RequestMapping(value = "/addSongFromFile")
    public boolean addSongFromFile(@RequestParam(value = "song") String song, @RequestParam(value = "singer") String singer) {
        return lyricsService.addSongFromFile(song.replace('*', ' ').replace(";", "&"), singer.replace('*', ' ').replace(";", "&"));
    }


}
