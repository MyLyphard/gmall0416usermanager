package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.mapper")
public class GmallusermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallusermanagerApplication.class, args);
	}
}
