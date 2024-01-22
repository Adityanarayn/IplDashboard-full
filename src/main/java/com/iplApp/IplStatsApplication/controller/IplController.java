package com.iplApp.IplStatsApplication.controller;

import com.iplApp.IplStatsApplication.model.IplModel;
import com.iplApp.IplStatsApplication.repository.IplRepo;
import com.iplApp.IplStatsApplication.service.IplService;
import com.iplApp.IplStatsApplication.utility.CSVReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@CrossOrigin
=======
@CrossOrigin(origins = "*")
>>>>>>> 8052f41 (Optimised it for upload on aws)
@RequestMapping("/ipl")
public class IplController {

    @Autowired
    CSVReaderUtil csvReaderUtil;
    @Autowired
    IplService iplService;

    @Autowired
    IplRepo iplRepo;


    @GetMapping("/test-ipl")
    public List<IplModel> test1(){

       return (List<IplModel>) iplRepo.findAll();


    }

    @GetMapping("/test2")
    public List<IplModel> test1(@Param("name")String name){


        return iplService.findByTeam1NameService(name);

    }

    @GetMapping("/teamName/{name}/matches/{year}")
    public List<IplModel> test2(@PathVariable String name, @PathVariable Integer year){
        return iplService.findMatchesWhereTeamNameIsService(name, year);
    }

//    @GetMapping("/MatchBetween")
//    public List<IplModel> test3{
//
//    }


}
