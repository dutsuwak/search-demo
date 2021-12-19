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

    //@GetMapping("/downloadFile/{titleName:.+}")
    @GetMapping("/search/{titleName:.+}")
    public ResponseEntity<Resource> search(@PathVariable String titleName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = searchService.loadFileAsResource(titleName);

        System.out.println(titleName);

        // Determine file's content type
        String contentType = "text/html";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "text/html; \"" + resource.toString() + "\"")
                .body(resource);
    }

}
