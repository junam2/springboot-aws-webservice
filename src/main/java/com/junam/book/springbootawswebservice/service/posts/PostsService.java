package com.junam.book.springbootawswebservice.service.posts;

import com.junam.book.springbootawswebservice.domain.posts.Posts;
import com.junam.book.springbootawswebservice.domain.posts.PostsRepository;
import com.junam.book.springbootawswebservice.web.dto.PostsListResponseDto;
import com.junam.book.springbootawswebservice.web.dto.PostsResponseDto;
import com.junam.book.springbootawswebservice.web.dto.PostsSaveRequestDto;
import com.junam.book.springbootawswebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        // jpa 영속성 컨텍스트로 인한 더티 체킹으로 따로 save 를 할 필요가 없다. (setter 사용과 같은 것)
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->
            new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    // readOnly = true 를 추가하면 조회 기능만 남겨두고 조회 속도가 개선된다.
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(post);
    }
}
