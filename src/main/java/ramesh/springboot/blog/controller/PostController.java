package ramesh.springboot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ramesh.springboot.blog.entity.Post;
import ramesh.springboot.blog.payload_dto.PostDto;
import ramesh.springboot.blog.payload_dto.PostResponse;
import ramesh.springboot.blog.service.PostService;
import ramesh.springboot.blog.utils.AppConstants;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(required = false,defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,value = "pageNo") int pageNo,
            @RequestParam(required = false,defaultValue = AppConstants.DEFAULT_PAGE_SIZE,value = "pageSize") int pageSize,
            @RequestParam(required = false,defaultValue = AppConstants.DEFAULT_SORT_BY, value ="sortBy") String sortBy,
            @RequestParam(required = false,defaultValue = AppConstants.DEFAULT_SORT_DIR, value ="sortDir") String sortDir){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable(name="id") long id){
        PostDto postResponse = postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteost(@PathVariable(name="id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post was successfully deleted",HttpStatus.OK);
    }
}
