package com.iplApp.IplStatsApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PlayerData")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id ;

    @Column(name = "PlayerName")
    private String name;

    @Column(name = "team_name")
    private List<String> teamName;

    @Column(name = "NumberOfMatches")
    private Integer numberOfMatches;


}
