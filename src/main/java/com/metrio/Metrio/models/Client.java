package com.metrio.Metrio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_login")
    private String clientLogin;

    @Column(name = "client_pass")
    private String clientPass;

    @Column(name = "client_status")
    private String clientStatus;

}