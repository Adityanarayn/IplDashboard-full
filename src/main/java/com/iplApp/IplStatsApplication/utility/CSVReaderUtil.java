package com.iplApp.IplStatsApplication.utility;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.model.VenueDetails;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import com.iplApp.IplStatsApplication.repository.PlayerRepo;
import com.opencsv.CSVReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.FileReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Locale;

@Component
@Slf4j
public class CSVReaderUtil {
    @Autowired
    IplRepo iplRepo;





    @SneakyThrows
//    public void fileReader(String filePath){
//        String line ="";
//        BufferedReader bufferedReader;
//        try {
//            bufferedReader= new BufferedReader(new FileReader(filePath));
//            while ((line = bufferedReader.readLine())!=null){
//                String[] s=line.split(",");
//                IplModel iplModel=new IplModel();
//
//                iplModel.setId(Integer.parseInt(s[0]));
//                iplModel.setCity(s[1]);
//                iplModel.setDate(s[2]);
//
//                iplModel.setSeason(s[3]);
//                iplModel.setMatchNumber(s[4]);
//                iplModel.setTeam1(s[5]);
//                iplModel.setTeam2(s[6]);
//                iplModel.setVenueDetails(new VenueDetails(s[7],s[8])); // we can face the problem here too
//                iplModel.setTossWinner(s[9]);
//                iplModel.setTossDecision(s[10]);
//                iplModel.setSuperOver(s[11]);
//                iplModel.setWinningTeam(s[12]);
//                iplModel.setWonBy(s[13]);
//                iplModel.setMargin(Integer.parseInt(s[14]));
//                iplModel.setPlayer_Of_Match(s[15]);
//
//                List<String> listOfPlayers1= parsePlayerList(s[16]);
//                iplModel.setTeam1Players(listOfPlayers1);
//
//                List<String> listOfPlayers2= parsePlayerList(s[17]);
//                iplModel.setTeam2Players(listOfPlayers2);
//
//                iplModel.setUmpire1(s[18]);
//                iplModel.setUmpire2(s[19]);
//
//                iplRepo.save(iplModel);
//
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }



    public void CsvFileReader(String filePath){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);
       try(CSVReader csvReader= new CSVReader(new FileReader(filePath))){

           String[] line ;
           while ((line = csvReader.readNext())!=null){
               IplModel iplModel=new IplModel();

                iplModel.setId(Integer.parseInt(line[0]));
                iplModel.setCity(line[1]);
                iplModel.setDate(LocalDate.parse(line[2],df));

                iplModel.setSeason(Integer.parseInt(line[3]));
                iplModel.setMatchNumber(line[4]);
                iplModel.setTeam1(line[5]);
                iplModel.setTeam2(line[6]);
                String[] newLine=line[7].split(",");
                iplModel.setVenueDetails(new VenueDetails(newLine[0])); // we can face the problem here too
                iplModel.setTossWinner(line[8]);
                iplModel.setTossDecision(line[9]);
                iplModel.setSuperOver(line[10]);
                iplModel.setWinningTeam(line[11]);
                iplModel.setWonBy(line[12]);
                iplModel.setMargin(line[13]);
                iplModel.setPlayerOfMatch(line[14]);


                List<String> listOfPlayers1= parsePlayerList(line[15]);
                iplModel.setTeam1Players(listOfPlayers1);

                List<String> listOfPlayers2= parsePlayerList(line[16]);
                iplModel.setTeam2Players(listOfPlayers2);

                iplModel.setUmpire1(line[17]);
                iplModel.setUmpire2(line[18]);

                iplRepo.save(iplModel);
                log.info("Sucessfully saved in the Database ");



           }

       }


    }

    public List<IplModel> CsvFileReaderList(String filePath){
        List<IplModel> iplModelList=new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

        try(CSVReader csvReader= new CSVReader(new FileReader(filePath))){

            String[] line ;
            while ((line = csvReader.readNext())!=null){
                IplModel iplModel=new IplModel();

                iplModel.setId(Integer.parseInt(line[0]));
                iplModel.setCity(line[1]);
                iplModel.setDate(LocalDate.parse(line[2],df));

                iplModel.setSeason(Integer.parseInt(line[3]));
                iplModel.setMatchNumber(line[4]);
                iplModel.setTeam1(line[5]);
                iplModel.setTeam2(line[6]);
                String[] newLine=line[7].split(",");
                iplModel.setVenueDetails(new VenueDetails(newLine[0])); // we can face the problem here too
                iplModel.setTossWinner(line[8]);
                iplModel.setTossDecision(line[9]);
                iplModel.setSuperOver(line[10]);
                iplModel.setWinningTeam(line[11]);
                iplModel.setWonBy(line[12]);
                iplModel.setMargin(line[13]);
                iplModel.setPlayerOfMatch(line[14]);


                List<String> listOfPlayers1= parsePlayerList(line[15]);
                iplModel.setTeam1Players(listOfPlayers1);

                List<String> listOfPlayers2= parsePlayerList(line[16]);
                iplModel.setTeam2Players(listOfPlayers2);

                iplModel.setUmpire1(line[17]);
                iplModel.setUmpire2(line[18]);

                iplModelList.add(iplModel);



            }

        }catch (Exception e){
            log.error("File Not Found ");
        }
        return iplModelList;



    }

    public List<String> parsePlayerList(String players){
        players=players.replaceAll("[\\[\\]']","");
        return Arrays.asList(players.split(","));
    }
}
