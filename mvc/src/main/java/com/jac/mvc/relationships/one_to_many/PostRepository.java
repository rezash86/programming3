package com.jac.mvc.relationships.one_to_many;

import com.jac.mvc.relationships.one_to_many.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
