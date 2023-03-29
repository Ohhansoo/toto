package com.toto.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 - JpaRepository를 상속받으면 CRUD 메소드 자동으로 상속
* */
public interface PostRepository extends JpaRepository<Posts, Long> {

}
