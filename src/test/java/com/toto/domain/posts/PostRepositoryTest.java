package com.toto.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    /*
     - Junit 5에선 @After -> @AfterEach
     - 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    * */
    @AfterEach
    public void cleanup(){
        postRepository.deleteAll();
    }
    
    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";
        
        /*
         - 테이블에 insert/update 쿼리 실행
        * */
        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hansoo")
                .build()
        );
        
        //when
        // - 테이블에 모든 데이터를 조회
        List<Posts> postsList = postRepository.findAll();
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}