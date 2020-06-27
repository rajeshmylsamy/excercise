package com.starnw.football.controller;

import com.starnw.football.model.Standing;
import com.starnw.football.service.StandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rajesh Mylsamy
 */

@RestController
public class StandingsController {

    @Autowired
    private StandingsService standingsService;

    @RequestMapping("/standings")
    public List<Standing> getStandings() {
        return standingsService.getStandings();
    }



}