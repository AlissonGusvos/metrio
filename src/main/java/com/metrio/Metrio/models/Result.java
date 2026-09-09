package com.metrio.Metrio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "results")
@Getter
@Setter
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaigns;

    private int clicks;

    @Column(name = "ad_spent")
    private BigDecimal adSpent;

    private int leads;
    private int reach;
    private int views;

}