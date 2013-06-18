package com.orangemako.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;

/**
 * MVC Servlet Context Configuration.
 *
 * @author Kevin Leong
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.orangemako.spring.controller"}) // Scans the following packages for classes with @Controller annotations
@PropertySource("classpath:/default-config.properties")
public class MvcContext extends WebMvcConfigurerAdapter {

    // Spring automatically autowires this.  Through this variable, properties
    // from the specified property source can be accessed.
    @Resource
    private Environment environment;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Provide a view resolver to map views to the correct template files.
     *
     * @return
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "animalType")
    public String getAnimalType() {
        return environment.getProperty("animal.type", String.class);
    }

    @Bean(name = "resumeURI")
    public String getResumeURI() {
        return environment.getProperty("resume.uri", String.class);
    }

    @Bean(name = "resumeContentDivId")
    public String getResumeContentDivId() {
        return environment.getProperty("resume.content.div.id", String.class);
    }
}
