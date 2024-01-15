package com.iplApp.IplStatsApplication.repository;

import com.iplApp.IplStatsApplication.model.Teams;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo  extends CrudRepository<Teams,Integer> {



    Teams findByName(String teamName);
    List<Teams> findByNameContaining(String teamName);
    Boolean existsByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Teams i SET i.totalNumberOfMatches= 1+ i.totalNumberOfMatches WHERE i.name= :name")
    void incrementTotalNumberOfMatches(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Teams i SET i.totalWins= 1+ i.totalWins WHERE i.name= :name")
    void incrementWins(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Teams i SET i.totalLoss= 1+ i.totalLoss WHERE i.name= :name")
    void incrementLoss(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Teams i SET i.totalDraws= 1+ i.totalDraws WHERE i.name= :name")
    void incrementDraws(@Param("name") String name);

    @Query("SELECT t.name FROM Teams t")
    List<String> getAllTeamNames();

}
