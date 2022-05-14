package com.heyahhhh.websitebackend;

import com.heyahhhh.websitebackend.service.impl.LyricsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebsiteBackendApplicationTests {

    @Test
    void contextLoads() {
        new LyricsServiceImpl().addSongFromFile("", "");
    }

}
