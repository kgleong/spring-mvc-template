package com.orangemako.spring.controller.webservice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * WebService Controller test class.
 *
 * @author Kevin Leong
 */
public class WebServiceControllerTemplateTest {

    WebServiceControllerTemplate webServiceController;

    @BeforeMethod
    public void setUp() {
        webServiceController = new WebServiceControllerTemplate();
    }

    @Test
    public void multiplyTest() throws Exception {

        int numOne = 3;
        int numTwo = 6;

        assertEquals(webServiceController.multiply(numOne, numTwo), 18);

        numOne = 5;
        numTwo = 2;

        assertEquals(webServiceController.multiply(numOne, numTwo), 10);

    }
}
