package com.heyahhhh.websitebackend.controller;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("/jar")
    public void test()  throws IOException {
//        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(ResourceUtils.CLASSPATH_URL_PREFIX + "lyrics/Taylor Swift/*.txt");
//        for(Resource resource : resources) {
//            System.out.println(resource.getFilename());
//        }
        Resource resource = new ClassPathResource("lyrics/Taylor Swift/Safe && Sound.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        System.out.println(br.readLine());
        br.close();

    }

}
