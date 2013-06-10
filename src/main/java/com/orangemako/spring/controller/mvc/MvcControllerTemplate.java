package com.orangemako.spring.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Basic MVC Controller.
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping
public class MvcControllerTemplate {

    @RequestMapping(value = "mvc", method = RequestMethod.GET)
    public String displayWelcomeMessage(ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome message from the Spring MVC Controller");
        return "welcome";
    }
}
