package ramesh.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ramesh.springboot.blog.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    Optional<Role> findRoleByName(String name);
}
