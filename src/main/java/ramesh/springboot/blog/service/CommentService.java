package ramesh.springboot.blog.service;

import ramesh.springboot.blog.payload_dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDTO);
    List<CommentDto> getAllCommentsByPostId(long postId);
}
