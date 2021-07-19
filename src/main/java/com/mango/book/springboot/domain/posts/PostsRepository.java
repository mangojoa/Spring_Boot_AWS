package com.mango.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Db Layer 접근자 / 기존의 DAO라고 생각해도 괜찮다.
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
