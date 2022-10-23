package ramesh.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ramesh.springboot.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
