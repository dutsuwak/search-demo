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

    @GetMapping("/searchByTitle/{titleName:.+}")
    public ResponseEntity<Resource> searchByTitle(@PathVariable String titleName, HttpServletRequest request) {
        Resource resource = searchService.searchByTitle(titleName);
        String contentType = "text/html";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "text/html; \"" + resource.toString() + "\"")
                .body(resource);
    }

    @GetMapping("/searchByGenre/{genreName:.+}")
    public ResponseEntity<Resource> searchByGenre(@PathVariable String genreName, HttpServletRequest request) {
        Resource resource = searchService.searchByGenre(genreName);
        String contentType = "text/html";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "text/html; \"" + resource.toString() + "\"")
                .body(resource);
    }

    @GetMapping("/searchByRate/{low:.+}/{high:.+}/{genre:.+}")
    public ResponseEntity<Resource> searchByGenre(@PathVariable String low, @PathVariable String high,
                                                  @PathVariable String genre, HttpServletRequest request) {
        Resource resource = searchService.searchByRate(Integer.parseInt(low), Integer.parseInt(high), genre);
        String contentType = "text/html";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "text/html; \"" + resource.toString() + "\"")
                .body(resource);
    }

}
