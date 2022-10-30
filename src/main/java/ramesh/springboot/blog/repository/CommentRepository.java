package ramesh.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ramesh.springboot.blog.entity.Comment;

public interface CommentRepository extends JpaRepository <Comment, Long>{
}
