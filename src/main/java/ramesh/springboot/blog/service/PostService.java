package ramesh.springboot.blog.service;

import ramesh.springboot.blog.payload_dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

}
