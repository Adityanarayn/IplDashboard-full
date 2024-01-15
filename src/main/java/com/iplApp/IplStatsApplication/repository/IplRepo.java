package com.iplApp.IplStatsApplication.repository;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.model.VenueDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IplRepo extends CrudRepository<IplModel,Integer> {

    List<IplModel> findByTeam1Containing(String teamName1);
    List<IplModel> findByTeam2Containing(String teamName2);

    @Query("SELECT p FROM IplModel p WHERE (p.team1 = :teamName OR p.team2 = :teamName) AND p.season= :year ORDER BY p.date")
    List<IplModel> findMatchesByTeamName(@Param("teamName") String teamName, @Param("year") Integer year);


    List<IplModel> findByCityContaining(String city);




    @Query("SELECT m FROM IplModel m WHERE m.matchNumber LIKE %:matchNumber% AND m.season=  :season")
    List<IplModel> findByMatchNumberOfSeasonEquals(@Param("matchNumber") String matchNumber, @Param("season") Integer season);

    @Query("SELECT i FROM IplModel i where i.venueDetails.stadiumName= :venue")
    List<IplModel> findByVenueDetailsContaining(@Param("venue") String venue);

    List<IplModel> findByTossWinnerContaining(String tossWinner);


    List<IplModel> findByPlayerOfMatchContaining(String name);
    @Query("SELECT i from IplModel i WHERE i.margin= (SELECT MAX(subI.margin) FROM IplModel subI)")
    IplModel findByHighestWinningMargin();

    @Query("SELECT i from IplModel i WHERE i.margin= (SELECT MIN(subI.margin) FROM IplModel subI)")
    IplModel findByLowestWinningMargin();

    @Query("SELECT t FROM IplModel t, IplModel m WHERE t.tossWinner = m.winningTeam")
    List<IplModel> findWhereTossWinnerAndMatchWinnerAreEqual(); // problem in this statement do it in the service layer


    @Query("SELECT m FROM IplModel m WHERE m.team1 = :teamName OR m.team2 = :teamName ORDER BY m.date DESC")
    List<IplModel> getLatestMatchesOfTeam(@Param("teamName") String teamName, Pageable pageable);



    // further more we can add the descending order of winning margin
    // which can be later on used for graphical analysis










    @Query("UPDATE IplModel i SET i.city= :city, i.season= :season, i.matchNumber= :matchNumber, i.team1= :team1, i.team2= :team2, " +
        "i.venueDetails= :venue, i.tossWinner= :tossWinner, i.tossDecision= :tossDecision, i.superOver= :superOver, " +
        "i.winningTeam= :winningTeam, i.wonBy= :wonBy, i.margin= :margin, i.playerOfMatch= :playerOfMatch, " +
        "i.team1Players= :team1Players, i.team2Players= :team2Players, i.umpire1= :umpire1, i.umpire2= :umpire2 " +
        "WHERE i.id= :id")
    void updateMatchById(@Param("id") Integer id,
                         @Param("city") String city,
                         @Param("season") Integer season,
                         @Param("matchNumber") String matchNumber,
                         @Param("team1") String team1,
                         @Param("team2") String team2,
                         @Param("venue") VenueDetails venueDetails ,
                         @Param("tossWinner") String tossWinner,
                         @Param("tossDecision") String tossDecision,
                         @Param("superOver") String superOver,
                         @Param("winningTeam") String winningTeam,
                         @Param("wonBy") String wonBy,
                         @Param("margin") String margin,
                         @Param("playerOfMatch") String playerOfMatch,
                         @Param("team1Players") List<String> team1Players,
                         @Param("team2Players") List<String> team2Players,
                         @Param("umpire1") String umpire1,
                         @Param("umpire2") String umpire2);



}
