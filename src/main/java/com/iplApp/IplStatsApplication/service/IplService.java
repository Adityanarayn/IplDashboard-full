package com.iplApp.IplStatsApplication.service;

import com.iplApp.IplStatsApplication.model.IplModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IplService {
    List<IplModel> findByTeam1NameService(String name);

    List<IplModel> findWhereTossWinnerAndMatchWinnerAreEqualService();

    List<IplModel> findMatchesWhereTeamNameIsService(String name, Integer year);




}
