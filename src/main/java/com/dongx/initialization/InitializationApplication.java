package com.dongx.initialization;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration    
@ComponentScan
@EnableTransactionManagement
@MapperScan("com.dongx.initialization.mapper")
@Slf4j
public class InitializationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializationApplication.class, args);
		log.info("\n\t==================project start success==================");
	}
}
