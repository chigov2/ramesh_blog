package ramesh.springboot.blog.payload_dto;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}