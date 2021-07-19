package com.mango.book.springboot.service.posts;

import com.mango.book.springboot.domain.posts.PostsRepository;
import com.mango.book.springboot.web.DTO.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
생성자로 주입받는 방식(@Autowired는 권장하지 않습니다.)
즉, 생성자로 Bean 객페를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있다는 것입니다.

@RequiredArgsConstructor를 사용하면 final이 선언된 모든 필드를
인자값으로 하는 생성자를 롬복의 @RequiredArgsContructor가 대신 생성해준다.
 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
