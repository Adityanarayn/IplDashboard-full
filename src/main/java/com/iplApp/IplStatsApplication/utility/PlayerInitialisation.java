package com.iplApp.IplStatsApplication.utility;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.model.Players;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import com.iplApp.IplStatsApplication.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

<<<<<<< HEAD

=======
import java.util.ArrayList;
import java.util.Arrays;
>>>>>>> 8052f41 (Optimised it for upload on aws)
import java.util.Collections;
import java.util.List;

@Component
public class PlayerInitialisation {

    @Autowired
    PlayerRepo playerRepo;
    @Autowired
    IplRepo iplRepo;
    @Autowired
    PlayerUtil playerUtil;


    public void playerDatabaseCreation1(){
        List<IplModel> iplModelList= (List<IplModel>) iplRepo.findAll();
        for (IplModel iplModel:iplModelList){
            List<String> playersTeam1=iplModel.getTeam1Players(); // you get back a list of players
            playerDatabaseCreation2(playersTeam1,iplModel.getTeam1());  // you are passing on the list of players in the argument

            List<String> playersTeam2=iplModel.getTeam2Players();
            playerDatabaseCreation2(playersTeam2,iplModel.getTeam2()); // this will get the list of players and the team they belong to

        }


    }

    public boolean databaseExists(){
        List<Players> playersList= (List<Players>) playerRepo.findAll();
        return !playersList.isEmpty(); // will return true if the database is not empty

    }

    public void playerDatabaseCreation2(List<String> playersList,String teamName){
        for (String player:playersList){
            if (!playerUtil.playerExists(player)){   // if the player is not present in the table we are creating a new entry
                Players players= new Players();
                players.setName(player);
//                players.setTeamName(teamName);
<<<<<<< HEAD
                players.setTeamName(List.of(teamName));
=======
                List<String> teamNames= new ArrayList<>();
                teamNames.add(teamName);
                players.setTeamName(teamNames);
>>>>>>> 8052f41 (Optimised it for upload on aws)
                players.setNumberOfMatches(1); // this will set the number of matches to 1 for the first entry of the player in the table
                playerRepo.save(players);

            }else { // what needs to be done here is that if the player is present in the table we are checking if he has remained in the same team or not
                if (!playerUtil.teamExistsInList(player,teamName)){

                    playerRepo.updateTeamNamesbyPlayer(player, Collections.singletonList(teamName));
                }

                else { // this is when the player exists and he has not changed teams

                    // now for this we need to access the repository and update the number of matches
                    playerRepo.incrementNumberOfMatches(player);

                }
            }
        }
    }
}
