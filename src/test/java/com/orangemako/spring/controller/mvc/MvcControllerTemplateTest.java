package com.orangemako.spring.controller.mvc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * MVC Test Class
 *
 * @author Kevin Leong
 */
public class MvcControllerTemplateTest {

    MvcControllerTemplate mvcController;

    @BeforeMethod
    public void setUp() {
        mvcController = new MvcControllerTemplate();
    }

    @Test
    public void testSum() throws Exception {

        int numOne = 5;
        int numTwo = 6;

        assertEquals(mvcController.sum(numOne, numTwo), 11);

        numOne = 111;
        numTwo = 5023;
        assertEquals(mvcController.sum(numOne, numTwo), 5134);
    }
}
