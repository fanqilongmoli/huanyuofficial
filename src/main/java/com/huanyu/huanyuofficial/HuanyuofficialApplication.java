package com.huanyu.huanyuofficial;

import com.huanyu.huanyuofficial.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@ComponentScan(basePackages = {"com.huanyu.huanyuofficial.*"})
@EnableConfigurationProperties(StorageProperties.class)
@EnableJpaAuditing
public class HuanyuofficialApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuanyuofficialApplication.class, args);
    }
}
