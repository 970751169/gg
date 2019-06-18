package com.gg.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gg.www.*.mapper")
public class ArticleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticleWebApplication.class, args);
	}
}

