package com.jetblue.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The Class Application.
 * @author JetBlue
 */
@SpringBootApplication(scanBasePackages = "com.jetblue.api")
public class Application extends SpringBootServletInitializer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /* (non-Javadoc)
     * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
     */
    @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
	 	return applicationBuilder.sources(Application.class);
	 }

}
