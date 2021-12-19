package com.search.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class SearchProperties {
    private String searchFilename;
    private String searchFramework;

    public String getSearchFilename() {
        return searchFilename;
    }

    public void setSearchFilename(String searchFilename) {
        this.searchFilename = searchFilename;
    }

    public String getSearchFramework() {
        return searchFramework;
    }

    public void setSearchFramework(String searchFramework) {
        this.searchFramework = searchFramework;
    }
}
