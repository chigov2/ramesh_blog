package ramesh.springboot.blog.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ramesh.springboot.blog.entity.Comment;
import ramesh.springboot.blog.entity.Post;
import ramesh.springboot.blog.exception.BlogAPIException;
import ramesh.springboot.blog.exception.ResourceNotFoundException;
import ramesh.springboot.blog.payload_dto.CommentDto;
import ramesh.springboot.blog.repository.CommentRepository;
import ramesh.springboot.blog.repository.PostRepository;
import ramesh.springboot.blog.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDTO) {
        Comment comment = mapToEntity(commentDTO);
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
        //set post to comment
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        return mapToDTO(savedComment);
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","id",commentId));
        //check if comment belong to post
        if (!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Comment does not belong to post");
        }

        return mapToDTO(comment);
    }

    private CommentDto mapToDTO(Comment comment){
//        CommentDto commentDto = mapper.map(comment, CommentDto.class);

        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return  commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
//        Comment comment = mapper.map(commentDto, Comment.class);
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return  comment;
    }
}
