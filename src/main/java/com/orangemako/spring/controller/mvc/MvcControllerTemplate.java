package com.orangemako.spring.controller.mvc;

import com.orangemako.spring.util.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Value;
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
    private static final Logger LOG = LoggerFactory.getLogger(MvcControllerTemplate.class);

    @Value("${animal.type}")
    String animalType;

    @RequestMapping(value = "mvc", method = RequestMethod.GET)
    public String displayWelcomeMessage(ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome message from the Spring MVC Controller");

        int numOne = 1;
        int numTwo = 2;

        StringBuilder calculationMessage = new StringBuilder();

        // Need to get the proxied object in order for any aspect-related calls to run.
        int sum = ((MvcControllerTemplate)AopContext.currentProxy()).sum(numOne, numTwo);

        calculationMessage.append(numOne)
                .append(" + ")
                .append(numTwo)
                .append(" = ")
                .append(sum);

        modelMap.addAttribute("calculation", calculationMessage.toString());

        modelMap.addAttribute("animalType", animalType);

        LoggerUtils.logMessagesAllLevels(LOG);

        return "welcome";
    }

    /**
     * Returns the sum of two numbers.
     *
     * @param numOne
     * @param numTwo
     * @return
     */
    public int sum(int numOne, int numTwo) {
        return numOne + numTwo;
    }
}
