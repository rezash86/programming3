package com.jac.mvc.relationships.one_to_one;

import com.jac.mvc.relationships.one_to_one.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
