package com.book.springboot.web.dto;

import com.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
/*
 * Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성했다
 * Entity 클래스를 Request/Response 클래스로 사용하면 안된다 !! Dto 클래스를 추가로 생성해야 함!
 * Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스로, 해당 클래스를 기준으로 테이블이 생성되고 스키마가 변경된다.
 * 사소한 기능 변경을 위해 테이블과 연결된 Entity 클래스를 변경하면 안됨~
 * 꼭 Entity 클래스와 Controller에서 쓸 DTO는 분리해서 사용하자
 * */