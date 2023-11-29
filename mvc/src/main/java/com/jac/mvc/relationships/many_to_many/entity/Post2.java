package com.jac.mvc.relationships.many_to_many.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="postsForTags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    private String description;

    private String content;

    @ManyToMany(mappedBy = "usedPost", cascade = CascadeType.ALL)
    List<Tag> usedTags;
}
