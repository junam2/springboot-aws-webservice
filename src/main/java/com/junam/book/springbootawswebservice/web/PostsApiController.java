package com.junam.book.springbootawswebservice.web;

import com.junam.book.springbootawswebservice.service.posts.PostsService;
import com.junam.book.springbootawswebservice.web.dto.PostsResponseDto;
import com.junam.book.springbootawswebservice.web.dto.PostsSaveRequestDto;
import com.junam.book.springbootawswebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    /*
    스프링에서 Bean 을 주입 받는 방식.
    1.@Autowired 2.setter 3.생성자

    여기서 @Autowired 대신 생성자를 사용한 이유
    - 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정해야하는 번거로움을 해결하기 위함
     */

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
