package ramesh.springboot.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ramesh.springboot.blog.payload_dto.CommentDto;
import ramesh.springboot.blog.repository.CommentRepository;
import ramesh.springboot.blog.service.CommentService;
import ramesh.springboot.blog.service.impl.CommentServiceImpl;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;
    private CommentRepository commentRepository;

    public CommentController(CommentService commentService, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @RequestBody CommentDto commentDto){
        return  new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }
}
