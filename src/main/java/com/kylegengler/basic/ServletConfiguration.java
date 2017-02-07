package com.kylegengler.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Configure the Spring dispatcher servlet
 * 
 * The configuration annotation designates this as a Spring configuration.
 * EnableWebMvc - tells spring to import and set up any configuration needed for
 * the controllers and any other mvc components. ComponentScan - Tells spring
 * the base package(s) to scan on the classpath for any spring @Components, or
 * any of its derivitives such as @Service, @Controller, or @Repository
 * 
 * This file will specify any @Beans that need to be managed by the Spring IoC                                                                                                  
 * container for Dependency Injection
 * 
 * @author kyle
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "com.kylegengler" })
public class ServletConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private ApplicationContext ctx;

	/**
	 * Set up the template resolver. This will look for templates in the
	 * /WEB-INF/templates directory, ending with html. This is used to find the
	 * template files needed to generate the view
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(ctx);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(true);
		return templateResolver;
	}

	/**
	 * The engine used to render the view using the template file and model.
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	/**
	 * The view resolver receives the name of the view, and is responsible for
	 * creating the corresponding View object to go with that view. It ties
	 * together the Controller logic and template engine.
	 */
	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}

}
