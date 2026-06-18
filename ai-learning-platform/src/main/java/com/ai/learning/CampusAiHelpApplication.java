package com.ai.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * AI赋能校园学习互助平台启动类
 */
@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableAsync
@EnableScheduling
public class CampusAiHelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusAiHelpApplication.class, args);
    }
}
