package com.rsjava.securityauthorize.security.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    private String uuid;
    private String name;
    private String password;
    private boolean active;
    private String roles;

    public UserEntity(String name,
                      String password,
                      String roles) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.password = password;
        this.active = true;
        this.roles = roles;
    }
}
