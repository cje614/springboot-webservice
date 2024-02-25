package com.book.springboot.domain.posts;

import com.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 나타낸다. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.) SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며 굳이 선언하지 않도라도 해당 클래스의 필드는 모두 컬럼이 된다. 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    /*
    * 1. 서비스 초기 구축 단계에선 테이블 설계(Entity 설계)가 빈번하게 변경되는데, 이때 롬복의 어노테이션들은 코드 변경량을 최소화시켜주기 때문에
    * 적극적으로 사용하자 ~!
    *
    * 2. Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다
    * -> 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하기 구분할 수가 없어, 차후 기능 변경 시 정말 복잡해지기 때문.
    * 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.
    *
    * */
}
