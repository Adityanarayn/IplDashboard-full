package com.iplApp.IplStatsApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teams")

public class Teams {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "team-id")
    private Integer id;

    @Column(name = "Name_of_Team")
    private String name;

    @Column(name = "total_number_of_matches")
    private Integer totalNumberOfMatches;

    @Column(name = "total_loss")
    private Integer totalLoss;

    @Column(name= "total_wins")
    private Integer totalWins;

    @Column(name = "total_draws")
    private Integer totalDraws;

    @Transient
    private List<IplModel> latestMatches;      // will get the details from the iplRepo for the latest matches of the team name containing the given name
}
