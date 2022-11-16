package ramesh.springboot.blog.payload_dto;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

//@ApiModel(description = "Post model information")
@Data
public class PostDto {
//    @ApiModelProperty(value = "Blog post ID")
    private long id;
    //title should not be null or empty
    //title should have at least 2 characters
    @NotEmpty(message = "Must not be empty")
    @Size(min = 2, message = "Title must have more then 2 characters")
//    @ApiModelProperty(value = "Blog post title")
    private String title;

    //must be not null or empty
    //should have at least 10 characters
    @NotEmpty(message = "Must not be empty")
    @Size(min = 10, message = "Description must have at least 10 characters")
//    @ApiModelProperty(value = "Blog post description")
    private String description;

    @NotEmpty(message = "Content must not be empty")
//    @ApiModelProperty(value = "Blog post content")
    private String content;
//    @ApiModelProperty(value = "Blog post comments")
//    private Set<CommentDto> comments;
    private Set<CommentDto> comments;
}
