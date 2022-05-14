package com.heyahhhh.websitebackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hometown")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HometownDO {
    private String province;
    private String city;
    private String desc;
}
