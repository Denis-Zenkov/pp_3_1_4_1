package com.example.pp_3_1_4_1.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "role")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + name.toUpperCase();
    }

    @Override
    public String toString() {
        return name;
    }

}
