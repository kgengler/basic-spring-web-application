package com.kylegengler.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Set up a simple controller for the application
 * 
 * @author kyle
 */
@Controller
public class IndexController {

	/**
	 * This will use the template at /WEB-INF/templates/index.html for the root
	 * and /home url paths.
	 */
	@RequestMapping({ "/", "/home" })
	public String getIndex() {
		return "index";
	}
}
