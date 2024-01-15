package com.iplApp.IplStatsApplication.service;

import com.iplApp.IplStatsApplication.model.Teams;

import java.util.List;

public interface TeamService {
    List<Teams> findByName(String name );
}
