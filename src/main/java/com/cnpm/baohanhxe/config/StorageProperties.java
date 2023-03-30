package com.cnpm.baohanhxe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("storage")
@Data
public class StorageProperties {
    private String location; //Luu file upload len server
}
