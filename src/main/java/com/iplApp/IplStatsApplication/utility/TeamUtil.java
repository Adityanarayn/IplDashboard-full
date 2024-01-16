package com.iplApp.IplStatsApplication.utility;

import com.iplApp.IplStatsApplication.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamUtil {
    TeamRepo teamRepo;
    @Autowired
    TeamUtil(TeamRepo teamRepo){
        this.teamRepo=teamRepo;

    }
    Boolean teamExistsByNameUtil(String teamName){
        return teamRepo.existsByName(teamName);
        // this will return true if the team exists  else False
    }
}
