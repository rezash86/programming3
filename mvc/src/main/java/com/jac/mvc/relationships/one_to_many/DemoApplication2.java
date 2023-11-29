package com.jac.mvc.relationships.one_to_many;

import com.jac.mvc.relationships.one_to_many.entity.Comment;
import com.jac.mvc.relationships.one_to_many.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication2 implements CommandLineRunner {

    private final PostRepository postRepository;

    @Autowired
    public DemoApplication2(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication2.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Comment comment1 = Comment.builder().text("This is cool").build();
        Comment comment2 = Comment.builder().text("This is cool 2").build();

        List<Comment> comments = List.of(comment1, comment2);

        Post post = Post
                .builder()
                .title("this is my vacation post3")
                .description("this is a description")
                .comments(comments)
                .build();

        postRepository.save(post);
    }
}
