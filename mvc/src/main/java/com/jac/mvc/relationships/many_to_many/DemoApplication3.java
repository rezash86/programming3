package com.jac.mvc.relationships.many_to_many;

import com.jac.mvc.relationships.many_to_many.entity.Post2;
import com.jac.mvc.relationships.many_to_many.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication3 implements CommandLineRunner {

    private final PostTagRepository postRepository;

    @Autowired
    public DemoApplication3(PostTagRepository postRepository) {
        this.postRepository = postRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication3.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Tag tag1 = Tag.builder().name("#McDonald").build();
        Tag tag2 = Tag.builder().name("#Vegeterian").build();

        Post2 post = Post2.builder().title("my title1")
                .content("Some content")
                .description("some desc")
                .usedTags(List.of(tag1, tag2)).build();

        tag1.setUsedPost(List.of(post));
        tag2.setUsedPost(List.of(post));

        postRepository.save(post);
    }
}
