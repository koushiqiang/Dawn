package com.neutrino.dawn;


import java.time.Duration;
import java.time.Instant;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@MapperScan("com.rynnova.**.mapper")
public class DawnApplication {
    private static final Logger log = LoggerFactory.getLogger(DawnApplication.class);

    public static void main(String[] args) {

        Instant inst1 = Instant.now();
        SpringApplication app = new SpringApplication(DawnApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

//        SpringApplication.run(DawnApplication.class, args);
        log.info("分布式数据库管理系统————基于 Spring Boot {} !", SpringBootVersion.getVersion());
        log.info("启动成功!  耗时:{}秒!", Duration.between(inst1, Instant.now()).getSeconds());
    }
}
