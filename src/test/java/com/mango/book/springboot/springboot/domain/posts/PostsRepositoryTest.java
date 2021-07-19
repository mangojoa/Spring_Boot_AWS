package com.mango.book.springboot.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @After // Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    // 보통은 베포 전 전체 테스트를 수행할때 테스트 간 데이터 침범을 막기 위해 사용
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void getPost(){
        // given
        String title = "Test Post";
        String content = "Test Content";

        // 테이블 posts에 insert/update 쿼리를 실행
        // id 값이 있다면 update가 없다면 insert 쿼리를 실행한다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("sxfc675@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();
        // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
