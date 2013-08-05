package com.orangemako.spring.controller.webservice;

import com.orangemako.spring.domain.User;
import com.orangemako.spring.domain.Weight;
import com.orangemako.spring.repository.WeightRepository;
import com.orangemako.spring.service.WeightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/**
 * Weight web service controller.
 *
 * @author Kevin Leong
 */
@Controller
@RequestMapping("weight")
public class WeightWebServiceController {
    private static final Logger LOG = LoggerFactory.getLogger(WeightWebServiceController.class);

    @Resource
    WeightRepository weightRepository;

    @Resource
    WeightService weightService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Weight> getAllWeights() {
        return weightRepository.findAll();
    }

    @RequestMapping(value = "userId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Weight> getWeightsForUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);

        return weightRepository.findByUser(user);
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public @ResponseBody
    int uploadCsv() {
        String filePath  = System.getProperty("user.home") + "/Desktop/weight.csv";

        return weightService.uploadWeightCsv(filePath);
    }


}
