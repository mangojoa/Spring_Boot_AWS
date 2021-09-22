package com.mango.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동추가 pubilc Posts(){} 와 같은 기능
@Entity // 테이블과 링크될 클래스를 나타낸다.
public class Posts extends BaseTimeEntity{

    @Id // 해당 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    // GenerationType.IDENTITY를 추가 해야만 auto_increment 된다.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    // 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 상관없다.
    // 사용한 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있다면 사용한다.
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title ,String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
