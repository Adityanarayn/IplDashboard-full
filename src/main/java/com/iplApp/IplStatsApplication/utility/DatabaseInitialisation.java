package com.iplApp.IplStatsApplication.utility;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
public class DatabaseInitialisation {
    @Autowired
    IplRepo iplRepo;
    @Autowired
    CSVReaderUtil csvReaderUtil;

    public boolean databaseExists(){
        List<IplModel> iplRepoList= (List<IplModel>) iplRepo.findAll();
        return !iplRepoList.isEmpty(); // it will return true if the database exists


    }

    public void compareAndUpdate(List<IplModel> newFile, String filePath){

        List<IplModel> oldFile = (List<IplModel>) iplRepo.findAll();
        if (oldFile.size()!= newFile.size()){
            iplRepo.deleteAll();
            csvReaderUtil.CsvFileReader(filePath); // this will save the new file in the database ;
            log.info("Database updated with the new File");


       }

        // now in case the size of the new file and the old file is same we need to compare all the fields
        // now here is a problem that the id is assigned by ourselves so we need to know the first id and the last id
        // however we can get the id which is Min and max to get the limits of the id value


        for (IplModel iplModelNew: newFile){
            for (IplModel iplModelOld: oldFile){

                if (iplModelOld.getId().equals(iplModelNew.getId())) {

                    if (!(iplModelNew.getCity().equals(iplModelOld.getCity())) &&
                            !(iplModelNew.getSeason().equals(iplModelOld.getCity())) &&
                            !(iplModelNew.getMatchNumber().equals(iplModelOld.getMatchNumber())) &&
                            !(iplModelNew.getTeam1().equals(iplModelOld.getTeam1())) &&
                            !(iplModelNew.getTeam2().equals(iplModelOld.getTeam2())) &&
                            !(iplModelNew.getVenueDetails().equals(iplModelOld.getVenueDetails())) &&
                            !(iplModelNew.getTossWinner().equals(iplModelOld.getTossWinner())) &&
                            !(iplModelNew.getTossDecision().equals(iplModelOld.getTossDecision())) &&
                            !(iplModelNew.getSuperOver().equals(iplModelOld.getSuperOver())) &&
                            !(iplModelNew.getWinningTeam().equals(iplModelOld.getWinningTeam())) &&
                            !(iplModelNew.getWonBy().equals(iplModelOld.getWonBy())) &&
                            !(iplModelNew.getMargin().equals(iplModelOld.getMargin())) &&
                            !(iplModelNew.getPlayerOfMatch().equals(iplModelOld.getPlayerOfMatch())) &&
                            !(iplModelNew.getTeam1Players().equals(iplModelOld.getTeam1Players())) &&
                            !(iplModelNew.getTeam2Players().equals(iplModelOld.getTeam2Players())) &&
                            !(iplModelNew.getUmpire1().equals(iplModelOld.getUmpire2()))) {
                        iplRepo.updateMatchById(iplModelNew.getId(),
                                iplModelNew.getCity(),
                                iplModelNew.getSeason(),
                                iplModelNew.getMatchNumber(),
                                iplModelNew.getTeam1(),
                                iplModelNew.getTeam2(),
                                iplModelNew.getVenueDetails(),
                                iplModelNew.getTossWinner(),
                                iplModelNew.getTossDecision(),
                                iplModelNew.getSuperOver(),
                                iplModelNew.getWinningTeam(),
                                iplModelNew.getWonBy(),
                                iplModelNew.getMargin(),
                                iplModelNew.getPlayerOfMatch(),
                                iplModelNew.getTeam1Players(),
                                iplModelNew.getTeam2Players(),
                                iplModelNew.getUmpire1(),
                                iplModelNew.getUmpire2()
                        );

                    }
                }
            }
        }
        log.info("Fields in the Database has been updated ");






    }
}
