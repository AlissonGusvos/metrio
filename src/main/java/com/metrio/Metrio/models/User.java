package com.metrio.Metrio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @Column(name = "hash_password")
    private String hashPassword;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_status")
    private String userStatus;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

}