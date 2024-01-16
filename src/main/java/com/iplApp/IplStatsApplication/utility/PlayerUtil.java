package com.iplApp.IplStatsApplication.utility;

import com.iplApp.IplStatsApplication.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PlayerUtil {
    @Autowired
    PlayerRepo playerRepo;
    public boolean playerExists(String playerName){ // this needs to check that the player playerName exists in the player database
       return playerRepo.existsByNameContaining( playerName);



    }

    public boolean teamExistsInList(String playerName, String teamName){


        // now the teamName is in the form of a list for the object player
        List<String> teamNames= playerRepo.getTeamNameByPlayer(playerName);

        for (String nameOfTeams : teamNames){
            if (nameOfTeams.equals(teamName)) return true ;
        }

        return  false ;



    }
}
