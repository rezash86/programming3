package com.jac.mvc.relationships.one_to_many.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

//    @ManyToOne
//    @JoinColumn(name="post_id")
//    private Post post;
}
