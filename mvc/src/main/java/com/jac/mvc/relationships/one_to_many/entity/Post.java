package com.jac.mvc.relationships.one_to_many.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Entity
@Table(name="posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", unique = true)
    @NotNull
    private String title;

    @NotBlank
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    @Size(max = 20000)
    private List<Comment> comments;
}
