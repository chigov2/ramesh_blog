package ramesh.springboot.blog.service.impl;

import org.springframework.stereotype.Service;
import ramesh.springboot.blog.entity.Post;
import ramesh.springboot.blog.payload_dto.PostDto;
import ramesh.springboot.blog.repository.PostRepository;
import ramesh.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    //constructor based dependency injection
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newPost = postRepository.save(post);

        //convert newPost to PostDto
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setContent(newPost.getContent());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setTitle(newPost.getTitle());

        return postResponse;
    }
}
