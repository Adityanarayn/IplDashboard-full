package com.iplApp.IplStatsApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ipl")
public class IplModel {
    @Id
    @Column(name = "Id")
    private Integer id;
    @Column(name = "City")
    private String city;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "Season")
    private Integer season;

    @Column(name = "MatchNumber")
    private String matchNumber;


    @Column(name = "Team-1")
    private String team1;


    @Column(name = "Team-2")
    private String team2;

    @Embedded
    @Column(name = "Venue")
    private VenueDetails venueDetails ;  // this might create problem in creating a bean s[7] and s[8]

    @Column(name = "Toss-Winner")
    private String tossWinner;

    @Column(name = "Toss-Decision")
    private String tossDecision;

    @Column(name = "Super-Over")
    private  String superOver;

    @Column(name = "Winning-Team")
    private  String winningTeam;

    @Column(name = "Won-By")
    private String wonBy;

    @Column(name = "Winning-Margin")
    private String margin;

    @Column(name = "Man-of-the-Match")
    private String playerOfMatch;

    @Column(name = "Team_1_Players")
    private List<String> team1Players; // this has to be taken care of


    @Column(name = "Team_2_Players")
    private List<String> team2Players ; //this has to be taken care of

    @Column(name = "Umpire-1")
    private String umpire1;

    @Column(name = "Umpire-2")
    private String umpire2;



}
