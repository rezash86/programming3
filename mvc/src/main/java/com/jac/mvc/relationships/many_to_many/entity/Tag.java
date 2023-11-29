package com.jac.mvc.relationships.many_to_many.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany
            @JoinTable(
                    name = "tag_post",
                    joinColumns = @JoinColumn(name="tag_id"),
                    inverseJoinColumns = @JoinColumn(name="post_id")
            )
    List<Post2> usedPost;
}
