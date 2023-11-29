package com.jac.mvc.relationships.one_to_one.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password", nullable = false, length = 200)
    private String passWord;

    @Column(name = "email", unique = true)
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "userprofile_id", referencedColumnName = "id")
    private UserProfile userProfile;
}
