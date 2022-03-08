package com.junam.book.springbootawswebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 제네릭에 entity 클래스 , pk 타입가 들어간다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
