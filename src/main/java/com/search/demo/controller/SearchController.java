package com.search.demo.controller;

import com.search.demo.service.SearchService;
import com.search.demo.controller.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    public SearchController(){
        System.out.println("Init");
    }

    @GetMapping("/searchByTitle/{titleName:.+}")
    public ResponseEntity<Resource> searchByTitle(@PathVariable String titleName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = searchService.searchByTitle(titleName);

        // Determine file's content type
        String contentType = "text/html";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "text/html; \"" + resource.toString() + "\"")
                .body(resource);
    }

    @GetMapping("/searchByGenre/{genreName:.+}")
    public ResponseEntity<Resource> searchByGenre(@PathVariable String genreName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = searchService.searchByGenre(genreName);

        // Determine file's content type
        String contentType = "text/html";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "text/html; \"" + resource.toString() + "\"")
                .body(resource);
    }

}
