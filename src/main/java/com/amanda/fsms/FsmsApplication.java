package com.amanda.fsms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@MapperScan(basePackages = "com.amanda.fsms.dao.mapper")
public class FsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsmsApplication.class, args);
	}

}
