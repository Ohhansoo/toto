package com.toto.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
/*
 기본 생성자 자동 추가
 public Posts(){}와 같은 효과
* */
@NoArgsConstructor
/* @Entity
 테이블과 링크될 클래스
 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
*/
@Entity
public class Posts {

    @Id
    /*
    PK 생성 규칙, GenerationType.IDENTITY를 추가해야만 auto_increment
    * */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    해당 클래스의 빌더 패턴 클래스를 생성
    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    * */
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
