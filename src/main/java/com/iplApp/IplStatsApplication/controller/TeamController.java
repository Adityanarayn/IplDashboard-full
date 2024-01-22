package com.iplApp.IplStatsApplication.controller;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.model.Teams;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import com.iplApp.IplStatsApplication.repository.TeamRepo;
import com.iplApp.IplStatsApplication.service.TeamService;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
<<<<<<< HEAD
@CrossOrigin  // can be used to specify the origin request url
=======
@CrossOrigin(origins = "*") // can be used to specify the origin request url
>>>>>>> 8052f41 (Optimised it for upload on aws)
@RequestMapping("/iplteams")
public class TeamController {
  private TeamRepo teamRepo;
  private IplRepo iplRepo;
  private TeamService teamService;

  public TeamController (TeamRepo teamRepo, TeamService teamService, IplRepo iplRepo){
    this.teamRepo=teamRepo;
    this.teamService=teamService;
    this.iplRepo=iplRepo;


  }


    @GetMapping("/test")
    public List<Teams> showAll(){
        return (List<Teams>) teamRepo.findAll();

    }
    @GetMapping("teamName/{teamName}")
    public  List<Teams> findByNameController(@PathVariable String teamName){

    return teamService.findByName(teamName);
    }

  @GetMapping("team/{teamName}")
  public  Teams findByController(@PathVariable String teamName){
      Teams teamInfo= teamRepo.findByName(teamName);
      Pageable pageable= PageRequest.of(0,4);   // this will limit the number of matches to the top 4 only
      teamInfo.setLatestMatches(iplRepo.getLatestMatchesOfTeam(teamName,pageable));
    return teamInfo;   // this will return you a single team entity from the database
  }


  @GetMapping("teamName/all")
  public List<String> getAllTeamNamesMethod() {
      return teamRepo.getAllTeamNames();
      
  }
  

  
  
}
