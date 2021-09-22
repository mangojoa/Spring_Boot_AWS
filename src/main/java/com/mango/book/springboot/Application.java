package com.mango.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
springboot의 Bean 읽기와 생성을 모두 자동설정
이게 있는 위치부터 설정을 읽어가기 때문에 프로젝트 상단에 위치해야 한다.
 */
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        System.out.println("어플리케이션 작동을 시작합니다");
        SpringApplication.run(Application.class, args);
        System.out.println("정상적으로 어플리케이션이 작동합니다.");
    }
}
