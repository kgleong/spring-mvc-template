package com.orangemako.spring.controller.webservice;

import com.orangemako.spring.util.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(WebServiceControllerTemplate.class);

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

        LoggerUtils.logMessagesAllLevels(LOG);

        return rval;
    }

    /**
     * Finds the product of two numbers.
     *
     * @param numOne
     * @param numTwo
     * @return
     */
    public int multiply(int numOne, int numTwo) {
        return numOne * numTwo;
    }
}
