package com.toto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springbootapplicaiotn으로 인해 스프링 부트의 자동 설정, 스프링 bean 읽기와 생성을 모두 자동으로 설정.
//특히 springbootapplication이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야함
@SpringBootApplication
public class Application {
    //앞으로 만들 프로젝트의 메인 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
