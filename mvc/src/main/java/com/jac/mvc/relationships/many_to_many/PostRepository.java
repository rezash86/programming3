package com.jac.mvc.relationships.many_to_many;

import com.jac.mvc.relationships.many_to_many.entity.Post2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post2, Long> {
}
