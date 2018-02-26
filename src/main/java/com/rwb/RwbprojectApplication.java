package com.rwb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot入口
 * 包含自动扫描mapper包
 */

@SpringBootApplication
@MapperScan("com.rwb.mapper")
public class RwbprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(RwbprojectApplication.class, args);
	}
}
