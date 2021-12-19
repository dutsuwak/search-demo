package com.search.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class SearchProperties {
    private String searchDirectory;

    public String getSearchDirectory() {
        return searchDirectory;
    }

    public void setSearchDirectory(String searchDirectory) {
        this.searchDirectory = searchDirectory;
    }
}
