package com.search.demo;

import com.search.demo.property.SearchProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		SearchProperties.class
})
public class SearchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchDemoApplication.class, args);
	}
}
