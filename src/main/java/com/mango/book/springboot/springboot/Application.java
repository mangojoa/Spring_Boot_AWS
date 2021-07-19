package com.mango.book.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// springboot의 Bean 읽기와 생성을 모두 자동설정
@SpringBootApplication // 이게 있는 위치부터 설정을 읽어가기 때문에 프로젝트 상단에 위치해야 한다.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
