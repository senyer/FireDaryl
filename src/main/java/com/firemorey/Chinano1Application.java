package com.firemorey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.firemorey.mapper")
public class Chinano1Application {

  public static void main(String[] args) {
    SpringApplication.run(Chinano1Application.class, args);
  }

}
