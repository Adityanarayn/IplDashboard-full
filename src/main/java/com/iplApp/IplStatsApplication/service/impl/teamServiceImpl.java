package com.iplApp.IplStatsApplication.service.impl;

import com.iplApp.IplStatsApplication.model.Teams;
import com.iplApp.IplStatsApplication.repository.TeamRepo;
import com.iplApp.IplStatsApplication.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teamServiceImpl implements TeamService {
    private TeamRepo teamRepo;

    @Autowired
    public teamServiceImpl(TeamRepo teamRepo){
        this.teamRepo=teamRepo;

    }



    @Override
    public List<Teams> findByName(String name) {
        return teamRepo.findByNameContaining(name);

    }
}
