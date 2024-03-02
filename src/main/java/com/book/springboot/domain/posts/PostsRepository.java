package com.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    // SpringDataJpa에서 제공하는 기본 메소드를 사용해도 되지만, 제공하지 않는 메소드는 아래처럼 @Query 를 사용
    @Query("SELECT p FROM Posts  p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

/*
* 보통 ibatis나 Mybatis 등에서 Dao라고 불리는 DB Layer 접근자이다.
* 단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
* */
