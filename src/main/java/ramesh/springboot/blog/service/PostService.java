package ramesh.springboot.blog.service;

import ramesh.springboot.blog.payload_dto.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
