package ramesh.springboot.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ramesh.springboot.blog.payload_dto.CommentDto;
import ramesh.springboot.blog.repository.CommentRepository;
import ramesh.springboot.blog.service.CommentService;
import ramesh.springboot.blog.service.impl.CommentServiceImpl;
import ramesh.springboot.blog.utils.AppConstants;

import javax.validation.Valid;
import java.util.List;

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
                                                    @Valid @RequestBody CommentDto commentDto){
        return  new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments")
    public List<CommentDto> getAllCommentsByPostId(@PathVariable(value = "postId") long postId){

        return commentService.getAllCommentsByPostId(postId);
    }
    @GetMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentByCommentId(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId){

        CommentDto commentDto = commentService.getCommentById(postId,commentId);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }
    @PutMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable(value = "postId") long postId,
            @PathVariable(value = "commentId") long commentId,
            @Valid @RequestBody CommentDto commentRequest
    ){
        CommentDto updatedComment = commentService.updateComment(postId,commentId,commentRequest);
        return new ResponseEntity<>(updatedComment,HttpStatus.OK);

    }
@DeleteMapping("posts/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
        @PathVariable(value = "postId") long postId,
        @PathVariable(value = "commentId") long commentId){
        commentService.deleteComment(postId,commentId);

        return new ResponseEntity<>(AppConstants.DEFAULT_DELETE_COMMENT,HttpStatus.OK);

    }
}
