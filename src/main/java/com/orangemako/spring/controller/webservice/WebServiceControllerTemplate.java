package com.orangemako.spring.controller.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic Web Service Controller.
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping
public class WebServiceControllerTemplate {

    @RequestMapping(value = "webService", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getInfo() {
        Map<String, Object> rval = new HashMap<String, Object>();

        rval.put("Application Name", "Spring MVC Template");

        Map<String, String> appInfo = new HashMap<String, String>();

        appInfo.put("Framework", "Spring MVC");
        appInfo.put("Dependency Management", "Maven");
        appInfo.put("Developer", "Kevin Leong");

        rval.put("Application Information", appInfo);

        return rval;
    }
}
