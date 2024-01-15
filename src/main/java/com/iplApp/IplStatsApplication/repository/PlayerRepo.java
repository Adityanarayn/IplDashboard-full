package com.iplApp.IplStatsApplication.repository;

import com.iplApp.IplStatsApplication.model.Players;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends CrudRepository<Players,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Players i SET i.numberOfMatches= 1+ i.numberOfMatches WHERE i.name= :name")
    void incrementNumberOfMatches(@Param("name") String name);
    @Query("SELECT t.teamName FROM Players t WHERE t.name= :name  ")
    List<String> getTeamNameByPlayer(@Param("name") String name);

    Boolean existsByNameContaining(String name); // this will give a true value if the player exists in the table

    @Transactional
    @Modifying
    @Query("UPDATE Players p SET p.teamName = :newTeamName WHERE p.name = :player")
    void updateTeamNamesbyPlayer(@Param("player") String name, @Param("newTeamName") List<String> teamName);
}



