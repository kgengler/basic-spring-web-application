package com.kylegengler.basic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class configures the web application. This replaces the traditional
 * web.xml file in servlet 3.0+ environments.
 * 
 * @author kyle
 */
public class WebApplicationConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Specify the root configuration classes. This is used for the business
	 * logic, and persistence classes. Since this application is just a basic
	 * "Hello World!" application, we'll be omitting it here.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Configuration classes for the servlet environment. This would include the
	 * Controllers and view resolvers.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ServletConfiguration.class };
	}

	/**
	 * Specify the url mappings that will be handled by the servlet.
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
