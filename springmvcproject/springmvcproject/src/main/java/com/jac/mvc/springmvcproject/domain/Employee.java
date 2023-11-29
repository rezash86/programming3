package com.jac.mvc.springmvcproject.domain;

import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
