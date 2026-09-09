package com.metrio.Metrio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "campaigns")
@Getter
@Setter
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clients;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @Column(name = "camp_name")
    private String campName;

    @Column(name = "camp_status")
    private String campStatus;

}