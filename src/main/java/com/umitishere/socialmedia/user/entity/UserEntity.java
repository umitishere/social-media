package com.umitishere.socialmedia.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity {

    @Id
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
