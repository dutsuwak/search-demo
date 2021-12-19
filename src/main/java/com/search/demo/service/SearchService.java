package com.search.demo.service;

import com.search.demo.controller.Movie;
import com.search.demo.frameworks.CSVSearchFramework;
import com.search.demo.frameworks.iSearchFramework;
import com.search.demo.property.SearchProperties;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class SearchService {

    private String searchFilename;
    private String searchFramework;
    private iSearchFramework db;

    @Autowired
    public SearchService(SearchProperties searchProperties) {
        this.searchFilename = searchProperties.getSearchFilename();
        this.searchFramework = searchProperties.getSearchFramework();

        switch (this.searchFramework){
            case "csv":
                this.db = new CSVSearchFramework();
                this.db.setup(this.searchFilename);
                break;
            case "elasticsearch":
                // TODO: Add elastic search support
                break;
            default:
                System.out.println("Framework not supported");
        }
    };

    public Resource searchByTitle(String title) {
        
        Movie mv = this.db.searchByTitle(title);

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("Name", mv.getName());
            jsonObj.put("Date", mv.getYear());
            jsonObj.put("Rate", mv.getRate());
            jsonObj.put("Votes", mv.getVotes());
            jsonObj.put("Genre", mv.getGenre());
            jsonObj.put("Duration", mv.getDuration());
            jsonObj.put("Type", mv.getType());
            jsonObj.put("Certificate", mv.getCertificate());
            jsonObj.put("Episodes", mv.getEpisodes());
            jsonObj.put("Nudity", mv.getNudity());
            jsonObj.put("Violence", mv.getViolence());
            jsonObj.put("Profanity", mv.getProfanity());
            jsonObj.put("Alcohol", mv.getAlcohol());
            jsonObj.put("Frightening", mv.getFrightening());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        InputStream targetStream = new ByteArrayInputStream(jsonObj.toString().getBytes());

        Resource resource = new InputStreamResource(targetStream);
        return resource;
    }
}
