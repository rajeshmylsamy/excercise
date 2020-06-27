package com.starnw.football.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.starnw.football.model.Standing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class StandingsService {

    @Autowired
    RestTemplate restTemplate;

    public String URL = "https://apiv2.apifootball.com/?action=get_standings&league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";



    public List<Standing> getStandings() {

        List<Standing> standings= new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        String response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class).getBody();
        JsonElement parsed = new JsonParser().parse(response);
        JsonArray jsonArray = parsed.getAsJsonArray();

        for (JsonElement jsonElement : jsonArray) {
            String country = jsonElement.getAsJsonObject().get("country_name").getAsString();
            String league = jsonElement.getAsJsonObject().get("league_name").getAsString();
            String team = jsonElement.getAsJsonObject().get("team_name").getAsString();
            Standing standing = new Standing();
            standing.setCountryName(country);
            standing.setTeamName(country);
            standing.setTeamName(country);
            standings.add(standing);
        }
        log.info(response);
        return standings;

    }




}
