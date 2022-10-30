package ramesh.springboot.blog.service;

import ramesh.springboot.blog.payload_dto.PostDto;
import ramesh.springboot.blog.payload_dto.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy,String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePost(long id);


}
