package ramesh.springboot.blog.service;

import ramesh.springboot.blog.payload_dto.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDTO);
}
