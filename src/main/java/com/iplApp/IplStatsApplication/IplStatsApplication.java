package com.iplApp.IplStatsApplication;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.utility.CSVReaderUtil;
import com.iplApp.IplStatsApplication.utility.DatabaseInitialisation;
import com.iplApp.IplStatsApplication.utility.PlayerInitialisation;
import com.iplApp.IplStatsApplication.utility.TeamInitialisation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import java.util.List;
@Slf4j
@SpringBootApplication
public class IplStatsApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(IplStatsApplication.class, args);
	}
	@Autowired
	DatabaseInitialisation databaseInitialisation;
	@Autowired
	CSVReaderUtil csvReaderUtil;
	@Autowired
	PlayerInitialisation playerInitialisation;

	@Autowired
	TeamInitialisation teamInitialisation;



	@Value("$(filePath)")
	private String filePath;


	@Override
	public void run(String... args) throws Exception {
		log.info("Checking the Database");
		String filePath2="/Users/adityanarayan/Documents/IplStatsApplication/src/main/java/com/iplApp/IplStatsApplication/utility/IPL_data.csv";

		if (!databaseInitialisation.databaseExists()) {  // if the database does not exist which means its empty
			try {
				csvReaderUtil.CsvFileReader(filePath2);
			} catch (Exception e) {
				log.error("File Cannot be Found in the system 1");
			}
		}else { // when the database exists check for differences and update the differences in the database
				try{
					List<IplModel> newFile=csvReaderUtil.CsvFileReaderList(filePath2);
					databaseInitialisation.compareAndUpdate(newFile,filePath2);
				}catch (Exception e) {
					log.error("File Cannot be Found in the system 2");
				}


		}
		log.info(" Checking for Player Database");
//		if (!playerInitialisation.databaseExists()){
//			log.info("creating the player database");
//			playerInitialisation.playerDatabaseCreation1();
//		}



		teamInitialisation.createDbForTeam();


	}



}
