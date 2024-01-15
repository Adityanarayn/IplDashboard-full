package com.iplApp.IplStatsApplication.utility;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.model.Teams;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import com.iplApp.IplStatsApplication.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TeamInitialisation {
    // first i will get all the data from the ipl repo in a list and
    // then i will feed that data into the team object

    IplRepo iplRepo;
    TeamRepo teamRepo;
    TeamUtil teamUtil;
    @Autowired
    public TeamInitialisation(IplRepo iplRepo, TeamRepo teamRepo, TeamUtil teamUtil){
        this.iplRepo=iplRepo;
        this.teamRepo=teamRepo;
        this.teamUtil=teamUtil;


    }

    public void createDbForTeam() {
        List<IplModel> listOfAllMatches = (List<IplModel>) iplRepo.findAll();

        for (IplModel iplModel : listOfAllMatches) {
            //Now we want to check if the team exists in the data base
            // if it does then we need to increment the number of matches won,
            // total number of matches , and lost matches
            // if not then we need to create an entry in the database
            Teams newTeam = new Teams();

            if (!(teamUtil.teamExistsByNameUtil(iplModel.getTeam1()))) { // if the team does not already exist in the db

                newTeam.setName(iplModel.getTeam1());
                newTeam.setTotalNumberOfMatches(1);
                String winningTeam= iplModel.getWinningTeam();

                newTeam.setTotalWins(0);
                newTeam.setTotalLoss(0);
                newTeam.setTotalDraws(0);

//                newTeam.setTotalNumberOfMatches(0);         // sets the initial values of the fields

                if (iplModel.getSuperOver().equalsIgnoreCase("Y")) { // if team 1 wins the match
                    newTeam.setTotalDraws(1);
                }

                if (winningTeam.equalsIgnoreCase(iplModel.getTeam1())) {
                    newTeam.setTotalWins(1);
                } else{
                    newTeam.setTotalLoss(1);
                }


                teamRepo.save(newTeam);


            } else {
                // this is when the team already exists in the database
                Teams oldTeam = teamRepo.findByName(iplModel.getTeam1());
                teamRepo.incrementTotalNumberOfMatches(oldTeam.getName());
                String winningTeam= iplModel.getWinningTeam();
                if (iplModel.getSuperOver().equalsIgnoreCase("Y")){
                    teamRepo.incrementDraws(oldTeam.getName());
                }
                if (winningTeam.equalsIgnoreCase(oldTeam.getName())){
                    teamRepo.incrementWins(oldTeam.getName());
                    oldTeam.setTotalLoss(oldTeam.getTotalNumberOfMatches()- oldTeam.getTotalWins()- oldTeam.getTotalDraws());
                } else{
                    teamRepo.incrementLoss(oldTeam.getName());
                    oldTeam.setTotalWins(oldTeam.getTotalWins()- oldTeam.getTotalLoss()- oldTeam.getTotalDraws());
                }



            }

            // now for team 2
            Teams newTeam2= new Teams();
            if (!(teamUtil.teamExistsByNameUtil(iplModel.getTeam2()))) { // if the team does not already exist in the db
                newTeam2.setName(iplModel.getTeam2());
                newTeam2.setTotalNumberOfMatches(1);
                String winningTeam= iplModel.getWinningTeam();

                newTeam2.setTotalWins(0);
                newTeam2.setTotalLoss(0);
                newTeam2.setTotalDraws(0);
//                newTeam2.setTotalNumberOfMatches(0);         // sets the initial values of the fields

                if (iplModel.getSuperOver().equalsIgnoreCase("Y")) { // if team 1 wins the match
                    newTeam2.setTotalDraws(1);
                }

                if (winningTeam.equalsIgnoreCase(iplModel.getTeam1())) {
                   newTeam2.setTotalWins(1);
                } else{
                    newTeam2.setTotalLoss(1);
                }

                teamRepo.save(newTeam2);


            } else {
                // this is when the team already exists in the database
                Teams oldTeam2 = teamRepo.findByName(iplModel.getTeam2());
                teamRepo.incrementTotalNumberOfMatches(oldTeam2.getName());
                String winningTeam= iplModel.getWinningTeam();
                if (iplModel.getSuperOver().equalsIgnoreCase("Y")){
                    teamRepo.incrementDraws(oldTeam2.getName());
                }
                if (winningTeam.equalsIgnoreCase(oldTeam2.getName())){
                    teamRepo.incrementWins(oldTeam2.getName());
                    oldTeam2.setTotalLoss(oldTeam2.getTotalNumberOfMatches()- oldTeam2.getTotalWins()- oldTeam2.getTotalDraws());
                } else{
                    teamRepo.incrementLoss(oldTeam2.getName());
                    oldTeam2.setTotalWins(oldTeam2.getTotalWins()- oldTeam2.getTotalLoss()- oldTeam2.getTotalDraws());
                }


            }

        }
    }

}
