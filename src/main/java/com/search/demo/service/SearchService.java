package com.search.demo.service;

import com.search.demo.property.SearchProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SearchService {

    private final Path searchLocation;

    @Autowired
    public SearchService(SearchProperties searchProperties) {
        this.searchLocation = Paths.get(searchProperties.getSearchDirectory())
                .toAbsolutePath().normalize();

        System.out.println(this.searchLocation);
    }

    public Resource loadFileAsResource(String fileName) {
        String initialString = "Result: " + fileName;
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());

        Resource resource = new InputStreamResource(targetStream);
        return resource;
    }
}
