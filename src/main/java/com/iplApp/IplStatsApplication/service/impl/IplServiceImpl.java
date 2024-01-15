package com.iplApp.IplStatsApplication.service.impl;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import com.iplApp.IplStatsApplication.service.IplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IplServiceImpl implements IplService {
    @Autowired
    IplRepo iplRepo;



    @Override
    public List<IplModel> findByTeam1NameService(String name) {
        return iplRepo.findByTeam1Containing(name);
    }

    public List<IplModel> findWhereTossWinnerAndMatchWinnerAreEqualService(){
        return iplRepo.findWhereTossWinnerAndMatchWinnerAreEqual();
    };

    public List<IplModel> findMatchesWhereTeamNameIsService(String name, Integer year){
        return iplRepo.findMatchesByTeamName(name, year);
    }

//    public List<IplModel> findMatchesBetweenTeams(String name1, String name2){
//        return iplRepo.findByMatchesBetween(name1,name2);
//    }




}
